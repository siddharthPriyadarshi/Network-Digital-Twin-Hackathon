package com.example.demo.UserNode;

import com.example.demo.UserNode.Entity.UserNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserNodeRepository extends Neo4jRepository<UserNode, Long> {
}
