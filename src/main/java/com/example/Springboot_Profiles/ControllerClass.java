package com.example.Springboot_Profiles;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerClass {

    @Value("${my.website.name}")
    private String websitename;


    @RequestMapping("/Profiles")
    public String  Welcome(){
        System.out.println("Welcome to "+websitename);
        return "Welcome to "+websitename;
    }
}
