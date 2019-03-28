package com.example.springboot.UserService;

import com.example.springboot.model.EmpUsers;

import java.util.List;

public interface EmpUsersMapperService {

    List<Object> selectAllUser();

    int insertSelective(EmpUsers record);

    EmpUsers selectUsers(String id);

    int updateByPrimaryKeySelective(EmpUsers record);

    int deleteByPrimaryKey(String id);
}
