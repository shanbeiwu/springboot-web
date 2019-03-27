package com.example.springboot.tools;

import java.util.UUID;

/**
 * 类中提供部分公共方法
 */
public class Commoms_Tools {
    /**
     * 生成id
     * 生成一个随机uuid
     */
    public static String getid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void main(String[] args) {
        System.out.println(getid());
    }
}
