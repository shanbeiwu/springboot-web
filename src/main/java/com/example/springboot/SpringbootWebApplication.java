package com.example.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@MapperScan(basePackages = "com.example.springboot.mapper")  //自动扫描包下的mapper，有此注解可以不用在mapper中添加@Mapper注解
@EnableTransactionManagement  //开启spring boot事务支持
@ServletComponentScan(basePackages = "com.example.springboot.filter")
public class SpringbootWebApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootWebApplication.class, args);
    }

}

