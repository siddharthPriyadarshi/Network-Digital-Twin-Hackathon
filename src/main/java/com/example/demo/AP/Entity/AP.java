package com.example.demo.AP.Entity;

import com.example.demo.OLT.Entity.Device_Status;
import com.example.demo.UserNode.Entity.UserNode;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;


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

    @Relationship(type = "CONNECTED_TO")
    private List<UserNode> userNodeConnected;
}
