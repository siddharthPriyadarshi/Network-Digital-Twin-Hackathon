package com.example.demo.AP;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class APController {

    @RequestMapping("/api")

    @PostMapping("/v1/ap")
    ResponseEntity<String> createAp(@RequestBody AP body){
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/v1/ap")
    ResponseEntity<List<String>> getAp(){
        return new ResponseEntity<>( new ArrayList<>(), HttpStatus.OK);
    }

    @GetMapping("/v1/ap/{id}")
    ResponseEntity<List<String>> getApById(@PathVariable Integer id){
        return new ResponseEntity<>( new ArrayList<>(), HttpStatus.OK);
    }


}
