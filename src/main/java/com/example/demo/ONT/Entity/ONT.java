package com.example.demo.ONT.Entity;

import com.example.demo.OLT.Entity.Device_Status;

//ONT: Optical Line Termination
public class ONT {
    private Integer id;
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
}
