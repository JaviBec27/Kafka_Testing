package com.kafka_test.test.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    @GetMapping("/b")
    public String getIndexString() {
        return "index";
    }

}
