package com.example.demo.AP;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface APRepository extends Neo4jRepository<AP, Long> {
}
