package com.example.springboot.mapper;

import com.example.springboot.model.EmpUsers;
import com.example.springboot.model.EmpUsersKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpUsersMapper {
    int deleteByPrimaryKey(String id);

    int insert(EmpUsers record);

    int insertSelective(EmpUsers record);

    EmpUsers selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EmpUsers record);

    int updateByPrimaryKey(EmpUsers record);

    List<Object> selectAllUser();
}