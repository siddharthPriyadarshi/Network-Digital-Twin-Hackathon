package com.example.demo.ONT.Entity;

import com.example.demo.AP.Entity.AP;
import com.example.demo.OLT.Entity.Device_Status;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

//ONT: Optical Line Termination
@Node("ONT")
public class ONT {
    @Id
    @GeneratedValue
    private Long id;
    private String ipAddress;
    private String firmwareVersion;
    private Integer uplinkSpeed;
    private Integer downlinkSpeed;
    private Integer utilization;
    private Device_Status status;
    private Float errorRate;
    private Integer temperature;
    private String createdAt;
    private String updatedAt;

    @Relationship(type = "HAS_ACCESS_POINT")
    List<AP> apConnected;
}
