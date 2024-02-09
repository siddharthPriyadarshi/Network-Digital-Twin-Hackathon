package com.example.demo.OLT.Entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;

//Optical Network Terminal
public class OLT {

    @Id
    @GeneratedValue
    private Integer id;

    private String firmawareVersion;
    private Integer ports;
    private Integer activeConnections;
    private Integer capacity;
    private Integer utilisation;
    private Integer uplinkBandwidth;
    private Integer downlinkBandwidth;
    private Integer bandwidthUtilisaiton;
    private Float errorRate;
    private Device_Status status;

    private String createdAt;
    private String updatedAt;

}
