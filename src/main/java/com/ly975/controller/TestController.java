package com.ly975.controller;

import com.ly975.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private Person person;

    @GetMapping("/test")
    public String test(){
        return person.getName();
    }
}
