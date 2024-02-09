package com.example.demo.UserNode;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("UserNode")
public class UserNode {

    @Id
    @GeneratedValue
    private Long id;
    private String deviceType;
    private String macAddress;
    private String ipAddress;
    private String signalStrength;
    private Integer dataRate;
    private Integer bandwidthUtilization;
}