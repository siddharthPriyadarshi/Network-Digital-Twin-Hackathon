package com.example.demo.BandwidthGraph.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "graph_data_table")
public class GraphData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Integer id;
    @Column(name="dev_count")
    Integer DeviceCount;
    @Column(name="bw_used")
    Integer totalBandwidthUsed;
    @Column(name="bw_rem")
    Integer bandwidthRemaining;
    String dateCreated;
}
