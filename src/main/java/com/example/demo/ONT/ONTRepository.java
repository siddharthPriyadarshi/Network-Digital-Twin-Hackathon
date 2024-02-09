package com.example.demo.ONT;

import com.example.demo.ONT.Entity.ONT;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ONTRepository extends Neo4jRepository<ONT, Long> {
}
