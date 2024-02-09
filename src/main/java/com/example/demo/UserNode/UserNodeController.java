package com.example.demo.UserNode;

import com.example.demo.UserNode.Entity.UserNode;
import com.example.demo.UserNode.UserNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class UserNodeController {
    @Autowired
    UserNodeService userNodeService;

    @PostMapping("v1/UserNode")
    public ResponseEntity<String> createUserNode(
            @RequestBody UserNode body
    ){
        userNodeService.saveOrCreate(body);
        return new ResponseEntity<>("UserNode created successfully", HttpStatus.OK);
    }

    @GetMapping("v1/UserNode")
    public ResponseEntity<List<UserNode>> getAllUserNode(){
        List<UserNode> UserNodeEntity = userNodeService.getAllUserNode();
        return new ResponseEntity<>(UserNodeEntity,HttpStatus.OK);
    }

    @GetMapping("v1/UserNode/{id}")
    public  ResponseEntity<UserNode> getUserNodeById(
            @PathVariable Long id
    ){
        Optional<UserNode> UserNodeEntity = userNodeService.getUserNodeById(id);
        return UserNodeEntity.map((object)->{
            return new ResponseEntity<>(object,HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("v1/UserNode/{id}")
    public ResponseEntity<UserNode> updateUserNode(
            @PathVariable Long id,
            @RequestBody UserNode body
    ){
        if (userNodeService.existsById(id)) {
            body.setId(id);
            UserNode UserNodeEntity = userNodeService.saveOrCreate(body);
            return new ResponseEntity<>(UserNodeEntity,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("v1/UserNode/{id}")
    public ResponseEntity<UserNode> deleteUserNode(
            @PathVariable Long id
    ){
        if (userNodeService.existsById(id)){
            Optional<UserNode> UserNodeEntity = userNodeService.deleteById(id);
            return UserNodeEntity.map((object)->{
                return new ResponseEntity<>(object,HttpStatus.OK);
            }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
