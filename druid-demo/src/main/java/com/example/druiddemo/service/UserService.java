package com.example.druiddemo.service;

import com.example.druiddemo.pojo.UserMysqlBean;
import com.example.druiddemo.pojo.UserPgsqlBean;

import java.util.List;

/**
 * @author: Staro
 * @date: 2020/5/22 11:03
 * @Description:
 */
public interface UserService {
    List<UserMysqlBean> getMySQLUser();

    List<UserPgsqlBean> getPgsqlUser();
}
