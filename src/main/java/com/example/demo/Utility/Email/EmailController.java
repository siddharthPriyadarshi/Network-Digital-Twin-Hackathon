package com.example.demo.Utility.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmailController {
	
	 @Autowired
	    private EmailServices emailServices;

	    @PostMapping("/email")
	    public ResponseEntity<Integer> sendEmail(){
	        System.out.println("Send email Controller");
	        emailServices.testEmail("sidmail4606@gmail.com");
	        return ResponseEntity.ok(200);
	    }
	    
	    @GetMapping("/test")
	    public String test() {
	    	return "Test Successful";
	    }

}
