package com.example.springboot.hellocontroller;

import com.example.springboot.UserService.EmpUsersMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmpUsersController {

    @Autowired
    private EmpUsersMapperService empUsersMapperService;
    /**
     * 返回员工列表页面
     */
    @GetMapping("/users/list")
    public String userList (Model model) {
        List<Object> list = empUsersMapperService.selectAllUser();

        model.addAttribute("emps", list);
        return "user/list";
    }

    /**
     * 跳转添加页面
     */
    @GetMapping("/users/add")
    public String toAddUsers() {

        return "user/add";
    }

}
