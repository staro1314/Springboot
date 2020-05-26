package com.example.druiddemo.controller;

import com.example.druiddemo.pojo.UserMysqlBean;
import com.example.druiddemo.pojo.UserPgsqlBean;
import com.example.druiddemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Staro
 * @date: 2020/5/22 11:02
 * @Description:
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("mysql")
    public List<UserMysqlBean> getMysqlUser(){
        return userService.getMySQLUser();
    }

    @RequestMapping("pgsql")
    public List<UserPgsqlBean> getPgsqlUser(){
        return userService.getPgsqlUser();
    }
}
