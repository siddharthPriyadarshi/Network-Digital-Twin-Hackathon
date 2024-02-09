package com.example.demo.AP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class APController {

    @Autowired
    APRepository apRepository;

    @PostMapping("/v1/ap")
    ResponseEntity<String> createAp(){

        AP ap = new AP();
        ap.setId(1L);
        ap.setSsid("123456");

        apRepository.save(ap);

        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/v1/ap")
    ResponseEntity<String> getAp(){
        return new ResponseEntity<>("HAckathon working", HttpStatus.OK);
    }

    @GetMapping("/v1/ap/{id}")
    ResponseEntity<List<String>> getApById(@PathVariable Integer id){
        return new ResponseEntity<>( new ArrayList<>(), HttpStatus.OK);
    }


}
