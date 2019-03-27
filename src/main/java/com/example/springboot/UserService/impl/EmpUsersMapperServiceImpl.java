package com.example.springboot.UserService.impl;

import com.example.springboot.UserService.EmpUsersMapperService;
import com.example.springboot.mapper.EmpUsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpUsersMapperServiceImpl implements EmpUsersMapperService {

    @Autowired
    private EmpUsersMapper empUsersMapper;

    @Override
    public List<Object> selectAllUser() {
        return empUsersMapper.selectAllUser();
    }

    public static void main(String[] args) {
        EmpUsersMapperServiceImpl e = new EmpUsersMapperServiceImpl();
        List list = e.selectAllUser();
        System.out.println(list);
    }
}
