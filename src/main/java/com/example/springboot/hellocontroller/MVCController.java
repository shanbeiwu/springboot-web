package com.example.springboot.hellocontroller;

import com.example.springboot.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MVCController {

    @RequestMapping("/boot/getUser")
    public Object getUser() {
 //       User user = new User();
 //       user.setId("100");
 //       user.setName("王麻子");

        return null;
    }
}
