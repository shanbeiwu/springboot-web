package com.example.springboot;

import com.example.springboot.UserService.EmpUsersMapperService;
import com.example.springboot.mapper.EmpDepartmentMapper;
import com.example.springboot.mapper.EmpUsersMapper;
import com.example.springboot.model.EmpUsers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootWebApplicationTests {

    @Autowired
    EmpDepartmentMapper empDepartmentMapper;

    @Autowired
    EmpUsersMapperService empUsersMapperService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Test
    public void test1() {
        stringRedisTemplate.opsForValue().append("msg", "hello");
    }

    @Test
    public void contextLoads() {
//        List list = empDepartmentMapper.getAllDepartment();
//        System.out.println(list);
       List<EmpUsers> page =  empUsersMapperService.findByPage(1, 2);
        PageInfo<EmpUsers> pageInfo = new PageInfo<>(page);
        System.out.println("LIST:" + page.get(0));
        System.out.println("PAGE:" +  pageInfo.toString());
    }
    @After
    public void afterTest() {
        List<Object> list = empUsersMapperService.selectAllUser();
        System.out.println(list);
    }

}

