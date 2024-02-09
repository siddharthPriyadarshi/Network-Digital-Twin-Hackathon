package com.example.demo.ONT;


import com.example.demo.ONT.Entity.ONT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class ONTController {

    @Autowired
    ONTService ontService;

    @PostMapping("v1/ont")
    public ResponseEntity<String> createONT(
            @RequestBody ONT body
    ){
        ontService.saveOrCreate(body);
        return new ResponseEntity<>("ONT created successfully", HttpStatus.OK);
    }

    @GetMapping("v1/ont")
    public ResponseEntity<List<ONT>> getAllOnt(){
        List<ONT> ontEntity = ontService.getAllOnt();
        return new ResponseEntity<>(ontEntity,HttpStatus.OK);
    }

    @GetMapping("v1/ont/{id}")
    public  ResponseEntity<ONT> getOntById(
            @PathVariable Long id
    ){
        Optional<ONT> ontEntity = ontService.getOntById(id);
        return ontEntity.map((object)->{
            return new ResponseEntity<>(object,HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("v1/ont/{id}")
    public ResponseEntity<ONT> updateOnt(
            @PathVariable Long id,
            @RequestBody ONT body
    ){
        if (ontService.existsById(id)) {
            body.setId(id);
            ONT ontEntity = ontService.saveOrCreate(body);
            return new ResponseEntity<>(ontEntity,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("v1/ont/{id}")
    public ResponseEntity<ONT> deleteOnt(
            @PathVariable Long id
    ){
        if (ontService.existsById(id)){
            Optional<ONT> ontEntity = ontService.deleteById(id);
            return ontEntity.map((object)->{
                return new ResponseEntity<>(object,HttpStatus.OK);
            }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
