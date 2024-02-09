package com.example.demo.OLT;

import com.example.demo.OLT.Entity.OLT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OLTController {

    @Autowired
    OLTService oltService;

    @PostMapping("v1/olt")
    public ResponseEntity<String> createOLT(
            @RequestBody OLT body
    ){
        oltService.saveOrCreate(body);
        return new ResponseEntity<>("OLT created successfully", HttpStatus.OK);
    }

    @GetMapping("v1/olt")
    public ResponseEntity<List<OLT>> getAllOlt(){
        List<OLT> oltEntity = oltService.getAllOlt();
        return new ResponseEntity<>(oltEntity,HttpStatus.OK);
    }

    @GetMapping("v1/olt/{id}")
    public  ResponseEntity<OLT> getOltById(
            @PathVariable Long id
    ){
        Optional<OLT> oltEntity = oltService.getOltById(id);
        return oltEntity.map((object)->{
            return new ResponseEntity<>(object,HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("v1/olt/{id}")
    public ResponseEntity<OLT> updateOlt(
            @PathVariable Long id,
            @RequestBody OLT body
    ){
        if (oltService.existsById(id)) {
            body.setId(id);
            OLT oltEntity = oltService.saveOrCreate(body);
            return new ResponseEntity<>(oltEntity,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("v1/olt/{id}")
    public ResponseEntity<OLT> deleteOlt(
            @PathVariable Long id
    ){
        if (oltService.existsById(id)){
            Optional<OLT> oltEntity = oltService.deleteById(id);
            return oltEntity.map((object)->{
                return new ResponseEntity<>(object,HttpStatus.OK);
            }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
