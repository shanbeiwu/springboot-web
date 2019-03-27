package com.example.springboot.UserService.impl;

import com.example.springboot.UserService.UserMapperService;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.model.User;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserMapperServiceImpl implements UserMapperService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllStudents() {
        return userMapper.selectAllUser();
    }

    @Override
    public User selectByid(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Transactional  //spring boot 事务管理，若方法中出现异常会回滚
    @Override
    public int updateStudents() {
        User user = new User();
        user.setId(1);
        user.setName("刘雨轩-666");
        user.setAge(18);
        user.setSex("男");
        int result = userMapper.updateByPrimaryKey(user);
        System.out.println("结果" + result);

        //此处构造一个异常，在运行时会提示，进而使之前的update操作回滚
        //int a = 10 / 0;

        return result;
    }
}
