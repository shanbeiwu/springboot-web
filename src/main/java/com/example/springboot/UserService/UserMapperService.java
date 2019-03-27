package com.example.springboot.UserService;

import com.example.springboot.model.User;

import java.util.List;

public interface UserMapperService {

    List<User> getAllStudents();

    int updateStudents();

    User selectByid(int id);
}
