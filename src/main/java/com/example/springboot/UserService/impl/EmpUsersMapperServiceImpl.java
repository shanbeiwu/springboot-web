package com.example.springboot.UserService.impl;

import com.example.springboot.UserService.EmpUsersMapperService;
import com.example.springboot.mapper.EmpUsersMapper;
import com.example.springboot.model.EmpUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpUsersMapperServiceImpl implements EmpUsersMapperService {


    private EmpUsersMapper empUsersMapper;

    @Autowired
    public EmpUsersMapperServiceImpl(EmpUsersMapper empUsersMapper) {
        this.empUsersMapper = empUsersMapper;
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return empUsersMapper.deleteByPrimaryKey(id);
    }

    @Override
    @CachePut(value = {"user"},key = "#record.id")
    public int updateByPrimaryKeySelective(EmpUsers record) {
        return empUsersMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Cacheable(value = {"user"}/*,keyGenerator = "myKeyGenerator"*/)
    public List<Object> selectAllUser() {
        return empUsersMapper.selectAllUser();
    }

    @Override
    public EmpUsers selectUsers(String id) {
        return empUsersMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertSelective(EmpUsers record) {
        return empUsersMapper.insertSelective(record);
    }

    public static void main(String[] args) {
//        EmpUsersMapperServiceImpl e = new EmpUsersMapperServiceImpl();
//        List list = e.selectAllUser();
//        System.out.println(list);
    }
}
