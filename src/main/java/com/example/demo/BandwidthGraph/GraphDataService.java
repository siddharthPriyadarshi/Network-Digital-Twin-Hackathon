package com.example.demo.BandwidthGraph;

import com.example.demo.AP.APRepository;
import com.example.demo.AP.Entity.AP;
import com.example.demo.BandwidthGraph.Entity.GraphData;
import com.example.demo.OLT.Entity.Device_Status;
import com.example.demo.OLT.Entity.OLT;
import com.example.demo.OLT.OLTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class GraphDataService {
    @Autowired
    GraphDataRepository graphDataRepository;

    public GraphData calculateAPBandwidthUtilization(AP ap, OLT olt, int constantBandwidthPerDevice) {

//        int totalBandwidthAP = ap.getTotalBandwidth();

        int totalDevices = ap.getCurrentConnections();
        int totalBandwidthUtilizedDevices = totalDevices * constantBandwidthPerDevice;

        int totalBandwidthOLT = olt.getBandwidthUtilisaiton();

        int bandwidthRemaining = totalBandwidthOLT - totalBandwidthUtilizedDevices ;

        if(bandwidthRemaining < 0){
            System.out.println("Device Limit exceeded. Burst Control triggerred");
        }

        GraphData graphData = new GraphData();
        graphData.setBandwidthRemaining(bandwidthRemaining);
        graphData.setDeviceCount(totalDevices);
        graphData.setTotalBandwidthUsed(totalBandwidthUtilizedDevices);

        graphDataRepository.save(graphData);

        return graphData;

    }

    public GraphData saveOrCreate(int connectedDevices, int usedBandwidth, Integer totalBandwidth) {
        GraphData graphData = new GraphData();
        
        graphData.setTotalBandwidthUsed(usedBandwidth);
        graphData.setBandwidthRemaining(totalBandwidth-usedBandwidth);
        graphData.setDeviceCount(connectedDevices);
        
        return graphDataRepository.save(graphData);
    }
}
