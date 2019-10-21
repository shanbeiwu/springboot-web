package com.example.springboot.model;

import lombok.Data;


import java.io.Serializable;
import java.util.Date;

@Data
public class EmpUsers extends EmpUsersKey implements Serializable {
    private String id;

    private Long order;

    private String department;

    private String personnelName;

    private Integer personnelAge;

    private Date personnelBirth;

    private String personnelGender;

    private Date pubCreattime;

    private String pubCreatperson;

    private Date pubLastchangetime;

    private String pubLastchangeperson;

}