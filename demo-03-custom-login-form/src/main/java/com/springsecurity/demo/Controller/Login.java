package com.springsecurity.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Login {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){

        return "plain-login";
    }
}
