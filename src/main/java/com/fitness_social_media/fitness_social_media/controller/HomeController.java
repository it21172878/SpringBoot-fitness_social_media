package com.fitness_social_media.fitness_social_media.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/homecontraller")
    public String homeControllerHandler(){
        return "This is Home Controller";
    }

}
