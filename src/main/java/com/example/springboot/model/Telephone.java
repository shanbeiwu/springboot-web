package com.example.springboot.model;

import com.example.springboot.tools.Info;
import lombok.Data;

@Data
public class Telephone {

    @Info(message = "手机号长度不对")
    private String telephone;
}
