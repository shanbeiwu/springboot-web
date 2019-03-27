package com.example.springboot.hellocontroller;


import com.example.springboot.UserService.UserMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserMapperService userMapperService;

    @RequestMapping("/boot/students")
    public Object students() {
        return userMapperService.getAllStudents();
    }

    @RequestMapping("/boot/update")
    public Object update() {
        return userMapperService.updateStudents();
    }

    @GetMapping("/boot/selectOne/{id}")
    public Object selectOne(@PathVariable("id") int id) {
        return  userMapperService.selectByid(id);
    }



}
