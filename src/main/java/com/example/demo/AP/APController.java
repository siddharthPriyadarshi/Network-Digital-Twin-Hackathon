package com.example.demo.AP;

import com.example.demo.AP.Entity.AP;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class APController {

    @Autowired
    APService apService;

    @PostMapping("/v1/ap")
    ResponseEntity<String> createAp(
            @RequestBody AP body
            ){
//        Long ArrayList<Long> connectedDevices = body.getId()
        apService.saveOrCreate(body);
        log.info("AP created successfully");
        return new ResponseEntity<>("Data Saved Successfully", HttpStatus.OK);
    }

    @GetMapping("/v1/ap")
    ResponseEntity<List<AP>> getAp(){
        List<AP> ap = apService.getAllAp();
        return new ResponseEntity<>(ap, HttpStatus.OK);
    }

    @GetMapping("/v1/ap/{id}")
    ResponseEntity<AP> getApById(@PathVariable Long id){
        Optional<AP> apEntity = apService.getApById(id);
        return apEntity.map((object)->{
            return new ResponseEntity<>(object,HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/v1/ap/{id}")
    ResponseEntity<AP> updateAP(
            @PathVariable Long id,
            @RequestBody AP body
    ){
        if (apService.existsById(id)) {
            body.setId(id);
            AP ap = apService.saveOrCreate(body);
            return new ResponseEntity<>(ap, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/v1/ap/{id}")
    ResponseEntity<AP> deleteAp(
            @PathVariable Long id
    ){
        Optional<AP> apEntity = apService.deleteById(id);
        return apEntity.map((object)->{
            return new ResponseEntity<>(object,HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
