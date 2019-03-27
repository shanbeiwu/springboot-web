package com.example.springboot.UserService.impl;

import com.example.springboot.UserService.EmpDepartmentMapperService;
import com.example.springboot.mapper.EmpDepartmentMapper;
import com.example.springboot.model.EmpDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpDepartmentMapperServiceImpl implements EmpDepartmentMapperService {

    @Autowired
    EmpDepartmentMapper empDepartmentMapper;

    @Override
    public List<EmpDepartment> getAllDepartment() {
        return empDepartmentMapper.getAllDepartment();
    }

    public static void main(String[] args) {
        EmpDepartmentMapperServiceImpl e = new EmpDepartmentMapperServiceImpl();
        System.out.println(e.getAllDepartment());
    }
}
