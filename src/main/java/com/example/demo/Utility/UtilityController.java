package com.example.demo.Utility;

import com.example.demo.AP.Entity.AP;
import com.example.demo.OLT.Entity.OLT;
import com.example.demo.OLT.OLTRepository;
import com.example.demo.ONT.Entity.ONT;
import com.example.demo.UserNode.Entity.UserNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class UtilityController {

    @Autowired
    OLTRepository oltRepository;
    @GetMapping("v1/calculateBandwidth")
    public void calculateBandwidth(){
        List<OLT> oltList = oltRepository.findAll();

        for(OLT olt : oltList){

            ONT ont = olt.getOnt();

            List<AP> apList = ont.getApConnected();

            Integer totalNodeBandwidth=0;
            for(AP ap : apList){
                List<UserNode> userNodeList = ap.getUserNodeConnected();
                for(UserNode userNode : userNodeList){
                    int nodeBandwidth = userNode.getBandwidthUtilization();
                    totalNodeBandwidth += nodeBandwidth;
                }
            }
            OLT findOlt = oltRepository.findById(olt.getId()).orElseThrow(()-> new RuntimeException("Issue with OLT GRAPH DB"));

            findOlt.setBandwidthUtilisaiton(olt.getTotalBandwidth() - totalNodeBandwidth);
            findOlt.setTotalBandwidth(olt.getTotalBandwidth() - totalNodeBandwidth);

            oltRepository.save(findOlt);
        }
    }
}
