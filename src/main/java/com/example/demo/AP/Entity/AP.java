package com.example.demo.AP.Entity;

import com.example.demo.OLT.Entity.Device_Status;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.util.ArrayList;


//Access Point
@Data
@Node("AP")
public class AP {
    @Id
    @GeneratedValue
    private Long id ;

    @Property("ssid")
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
