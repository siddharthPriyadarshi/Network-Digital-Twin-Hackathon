package com.example.demo.BandwidthGraph;

import com.example.demo.AP.APRepository;
import com.example.demo.AP.Entity.AP;
import com.example.demo.BandwidthGraph.Entity.GraphData;
import com.example.demo.OLT.Entity.Device_Status;
import com.example.demo.OLT.Entity.OLT;
import com.example.demo.OLT.OLTRepository;
import com.example.demo.ONT.Entity.ONT;
import com.example.demo.Utility.Email.EmailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class GraphDataService {
    @Autowired
    GraphDataRepository graphDataRepository;

    @Autowired
    private EmailServices emailServices;

    public boolean isSecondaryDeviceAvailable(ONT secondaryDevice, int wastedBandwidth) {
        // Check status to know whether device is available to connect or not
        //i.e. device is online or offlice or under_Maintainance
        if (secondaryDevice.getStatus() == Device_Status.ONLINE ) {
            // Check if secondary device can handle additional bandwidth
            if (secondaryDevice.getUplinkSpeed() >= wastedBandwidth) {
                System.out.println("PRIMARY <-> BACKUP DEVICE");
                System.out.println("BACKUP DEVICE STARTED");

                emailServices.testEmail("email@gmail.com");

                System.out.println("CHECK ADMIN EMAIL(sidmail4606@gmail.com) FOR ANY UPDATE");

                return true;
            }
        }
        return false;
    }

    public GraphData calculateAPBandwidthUtilization(AP ap, OLT olt, int constantBandwidthPerDevice) {
        int totalDevices = ap.getCurrentConnections();
        int totalBandwidthUtilizedDevices = totalDevices * constantBandwidthPerDevice;
        int totalBandwidthOLT = olt.getBandwidthUtilisaiton();
        int bandwidthRemaining = totalBandwidthOLT - totalBandwidthUtilizedDevices ;
        if(bandwidthRemaining < 0){
            System.out.println("Data packets going to dropped(Bandwidth Remaining): "+ (bandwidthRemaining*-1));
            System.out.println("Device Limit exceeded. Burst Control triggerred");
            if(isSecondaryDeviceAvailable(olt.getBackupOnt(), bandwidthRemaining)){
                System.out.println("Switching to other secondary device");
                emailServices.testEmail("email@gmail.com"); //triggerAlert
            }else{
                System.out.println("BACKUP OLT DEVICE IS NOT THERE FOR BACKUP");
            }
        }
        GraphData graphData = new GraphData();
        if(bandwidthRemaining < 0){
            bandwidthRemaining = 0;
        }
        graphData.setBandwidthRemaining(bandwidthRemaining);
        graphData.setDeviceCount(totalDevices);
        graphData.setTotalBandwidthUsed(totalBandwidthUtilizedDevices);

        graphDataRepository.save(graphData);







        return graphData;

    }

    public GraphData saveOrCreate(int connectedDevices, int usedBandwidth, Integer totalBandwidth) {
        GraphData graphData = new GraphData();
        
        graphData.setTotalBandwidthUsed(usedBandwidth);
        int remainingBandwidth = totalBandwidth-usedBandwidth;

        if(remainingBandwidth<0){
            remainingBandwidth = 0;
        }
        graphData.setBandwidthRemaining(remainingBandwidth);
        graphData.setDeviceCount(connectedDevices);
        
        return graphDataRepository.save(graphData);
    }
}
