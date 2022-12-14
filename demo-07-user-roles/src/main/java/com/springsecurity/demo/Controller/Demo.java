package com.springsecurity.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Demo {

    @GetMapping("/")
    public String showHome(){

        return "home";
    }

    // add request mapping for leaders
    @GetMapping("/leaders")
    public String showLeaders(){

        return "leaders";
    }

    // add request mapping for systems
    @GetMapping("/systems")
    public String showSystems(){

        return "systems";
    }

}
