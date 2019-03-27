package com.example.springboot.mapper;

import com.example.springboot.model.EmpDepartment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpDepartmentMapper {
    int deleteByPrimaryKey(String id);

    int insert(EmpDepartment record);

    int insertSelective(EmpDepartment record);

    EmpDepartment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EmpDepartment record);

    int updateByPrimaryKey(EmpDepartment record);

    List<EmpDepartment> getAllDepartment();
}