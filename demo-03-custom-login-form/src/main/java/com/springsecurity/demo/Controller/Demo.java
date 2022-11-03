package com.springsecurity.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Demo {

    @GetMapping("/")
    public String showHome(){

        return "home";
    }
}
