package com.praktika.worktime.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("v1/users")
public class UserController {

    @GetMapping("/greeting")
    public ResponseEntity<String> getHello(){
        return new ResponseEntity<>("Hello!",HttpStatus.OK);
    }
}
