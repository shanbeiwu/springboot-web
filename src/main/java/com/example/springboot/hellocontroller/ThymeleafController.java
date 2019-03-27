package com.example.springboot.hellocontroller;

import com.example.springboot.UserService.UserMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ThymeleafController {

    @Autowired
    private UserMapperService userMapperService;

    @RequestMapping("/boot/TLTest")
    public  String test(Model model, HttpServletRequest request) {
        model.addAttribute("list", userMapperService.getAllStudents());

        request.setAttribute("msg", "this is request");
        return "user";
    }

    @RequestMapping("/boot/test")
    public String tt(Model model) {
        model.addAttribute("test", "this is thymeleaf page!");

        return "use";
    }
}
