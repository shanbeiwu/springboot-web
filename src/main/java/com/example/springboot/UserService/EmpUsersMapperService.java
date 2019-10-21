package com.example.springboot.UserService;

import com.example.springboot.model.EmpUsers;
import com.github.pagehelper.Page;

import java.util.List;

public interface EmpUsersMapperService {

    List<Object> selectAllUser();

    int insertSelective(EmpUsers record);

    EmpUsers selectUsers(String id);

    int updateByPrimaryKeySelective(EmpUsers record);

    int deleteByPrimaryKey(String id);

    /**
     * 分页查询
     * @param pageNo 页号
     * @param pageSize 每页显示记录数
     * @return
     */
    List<EmpUsers> findByPage(int pageNo, int pageSize);
}
