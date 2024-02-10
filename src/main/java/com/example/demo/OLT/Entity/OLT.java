package com.example.demo.OLT.Entity;


import com.example.demo.ONT.Entity.ONT;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

//Optical Network Terminal

@Data
@Node("OLT")
public class OLT {

    @Id
    @GeneratedValue
    private Long id;

    private String firmawareVersion;
    private Integer ports;
    private Integer activeConnections;
    private Integer capacity;
    private Integer utilisation;
    private Integer uplinkBandwidth;
    private Integer downlinkBandwidth;
    private Integer bandwidthUtilisaiton; // totlal BW
    private Float errorRate;
    private Device_Status status;
    private Integer totalBandwidth;

    private String createdAt;
    private String updatedAt;

    @Relationship(type = "CONNECTED_TO")
    private ONT ont;

    @Relationship(type = "CONNECTED_TO")
    private ONT backupOnt;

}
