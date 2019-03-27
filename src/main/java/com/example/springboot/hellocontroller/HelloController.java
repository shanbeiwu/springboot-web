package com.example.springboot.hellocontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("/hello/boot")
    public @ResponseBody String hello () {
        return "Hello String Boot";
    }

}
