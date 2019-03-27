package com.example.springboot.hellocontroller;

import com.example.springboot.UserService.UserMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    UserMapperService userMapperService;

    @PostMapping("/boot/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session){
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            //为防止表单重复提交，可以使用重定向到主页
            session.setAttribute("loginuser", username);
            return "redirect:/main.html";
        } else {
            map.put("msg", "用户和密码有误");
            return "Login";
        }

    }
}
