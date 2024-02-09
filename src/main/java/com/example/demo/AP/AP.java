package com.example.demo.AP;

import com.example.demo.OLT.Entity.Device_Status;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;

import java.util.ArrayList;


//Access Point
public class AP {
    @Id
    @GeneratedValue
    private Integer id ;
    private String ssid;
    private String macAddress;
    private ArrayList<String> supportedFrequencies;

    private Integer maxConnections;
    private Integer currentConnections;
    private Integer totalBandwidth;
    private Integer bandwidthUtilisation;
    private Float errorRate;
    private Device_Status status;
}
