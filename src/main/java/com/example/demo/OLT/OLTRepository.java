package com.example.demo.OLT;

import com.example.demo.OLT.Entity.OLT;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OLTRepository extends Neo4jRepository<OLT, Long> {
}
