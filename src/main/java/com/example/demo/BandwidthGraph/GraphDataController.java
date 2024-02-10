package com.example.demo.BandwidthGraph;

import com.example.demo.AP.APRepository;
import com.example.demo.AP.APService;
import com.example.demo.AP.Entity.AP;
import com.example.demo.BandwidthGraph.Entity.GraphData;
import com.example.demo.OLT.Entity.OLT;
import com.example.demo.OLT.OLTRepository;
import com.example.demo.OLT.OLTService;
import com.example.demo.ONT.Entity.ONT;
import com.example.demo.ONT.ONTRepository;
import com.example.demo.ONT.ONTService;
import com.example.demo.UserNode.Entity.UserNode;
import com.example.demo.UserNode.UserNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GraphDataController {
    @Autowired
    GraphDataService graphDataservice;

    @Autowired
    APService apService;

    @Autowired
    OLTService oltService;

    @Autowired
    UserNodeService userNodeService;

    @Autowired
    APRepository apRepository;

    @Autowired
    ONTRepository ontRepository;

    @Autowired
    OLTRepository oltRepository;


    public OLT getConnectedOLT(List<OLT> oltList, ONT findOnt){
        OLT olt = new OLT();

        for(OLT oltDevice : oltList){
            if(oltDevice.getId()==findOnt.getId()){
                olt = oltDevice;
            }
        }

        return olt;
    }


    public ONT getConnectedONT(List<ONT> ontList, AP findAp){
        ONT ont = new ONT();
        for(ONT ontDev : ontList){
            List<AP> apList = ontDev.getApConnected();
            for(AP ap : apList){
                if(ap.getId() == findAp.getId()){
                    ont = ontDev;
                    break;
                }
            }
        }

        return ont;
    }
    public AP getConnectedAp(List<AP> apList, UserNode userNode){
        AP accessPoint = new AP();
        for(AP ap: apList){
            List<UserNode> userNodes = ap.getUserNodeConnected();
            for(UserNode node : userNodes){
                if(node.getId() == userNode.getId()){
                    accessPoint = ap;
                }
            }
        }
        return accessPoint;
    }
    @PostMapping("/getGraphData/{nodeId}")
    public GraphData getGraphData(@PathVariable Long nodeId){

        UserNode userNode = userNodeService.getUserNodeById(nodeId).orElseThrow(()->new RuntimeException("User Node not found in Repo"));
        List<AP> apList = apRepository.findAll();

        AP connectedAp = getConnectedAp(apList, userNode);
        int connectedDevices = connectedAp.getUserNodeConnected().size();
        int usedBandwidth = 50 * connectedDevices ;//assume fixed bandwidth 50

        OLT connectedOLT = getConnectedOLT(oltRepository.findAll(),  getConnectedONT(ontRepository.findAll(), connectedAp) );
//        Integer totalBandwidth = connectedOLT.getTotalBandwidth();

        Integer totalBandwidth = 100;

        return graphDataservice.saveOrCreate(connectedDevices, usedBandwidth, totalBandwidth);
    }
}
