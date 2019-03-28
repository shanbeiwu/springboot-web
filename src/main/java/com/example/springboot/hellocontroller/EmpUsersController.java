package com.example.springboot.hellocontroller;

import com.example.springboot.UserService.EmpDepartmentMapperService;
import com.example.springboot.UserService.EmpUsersMapperService;
import com.example.springboot.model.EmpDepartment;
import com.example.springboot.model.EmpUsers;
import com.example.springboot.tools.Commoms_Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpUsersController {

    private EmpUsersMapperService empUsersMapperService;

    private EmpDepartmentMapperService empDepartmentMapperService;

    @Autowired
    public EmpUsersController(EmpUsersMapperService empUsersMapperService, EmpDepartmentMapperService empDepartmentMapperService) {
        this.empUsersMapperService = empUsersMapperService;
        this.empDepartmentMapperService = empDepartmentMapperService;
    }


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
    public String toAddUsers(Model model) {
        List<EmpDepartment> department = empDepartmentMapperService.getAllDepartment();
        model.addAttribute("department", department);
        return "user/add";
    }

    /**
     * 添加员工
     */
    @PostMapping("/emp")
    public String addEmp(EmpUsers empUsers) {

        empUsers.setId(Commoms_Tools.getid());
        empUsers.setPubCreattime(Commoms_Tools.getdate());
        empUsers.setOrder(Commoms_Tools.dateToNumber(Commoms_Tools.getdate()));
        empUsers.setPubLastchangetime(Commoms_Tools.getdate());
        System.out.println("添加员工信息：" + empUsers);

        int result = empUsersMapperService.insertSelective(empUsers);
        System.out.println("result:" + result);
        if (result == 1) {
            return "redirect:/users/list";
        } else {
            return "redirect:/users/list";
        }
    }

    /**
     * 跳转到修改页面
     * @return String
     */
    @GetMapping("/emp/update/{id}")
    public String toEditPage(@PathVariable("id") String id, Model model) {
        EmpUsers empUsers = empUsersMapperService.selectUsers(id);
        model.addAttribute("empusers", empUsers);

        List<EmpDepartment> department = empDepartmentMapperService.getAllDepartment();
        model.addAttribute("department", department);

        return "user/add";
    }

    @PutMapping("/emp")
    public String updateEmp(EmpUsers empUsers) {

        System.out.println("修改员工信息："+ empUsers);
        int result = empUsersMapperService.updateByPrimaryKeySelective(empUsers);

        if (result == 1) {
            return "redirect:/users/list";
        } else {
            return "redirect:/users/list";
        }
    }

    @DeleteMapping("/emp/delete/{id}")
    public String deleteEmp(@PathVariable("id") String id) {

        int result = empUsersMapperService.deleteByPrimaryKey(id);
        if (result == 1) {
            return "redirect:/users/list";
        } else {
            return "redirect:/users/list";
        }
    }
}
