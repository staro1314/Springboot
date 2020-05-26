package com.example.druiddemo.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author: Staro
 * @date: 2020/5/22 12:00
 * @Description:
 */
@Getter
@Setter
@ToString
public class UserPgsqlBean {
    private int id;
    private String name;
    private int age;
    private int salary;
    private Date addTime;
    private float proportional;
}
