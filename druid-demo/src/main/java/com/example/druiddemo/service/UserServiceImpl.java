package com.example.druiddemo.service;

import com.example.druiddemo.dao.mysql.UserMysqlMapper;
import com.example.druiddemo.dao.pgsql.UserPgsqlMapper;
import com.example.druiddemo.pojo.UserMysqlBean;
import com.example.druiddemo.pojo.UserPgsqlBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: Staro
 * @date: 2020/5/22 11:03
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMysqlMapper userMysqlMapper;

    @Resource
    private UserPgsqlMapper userPgsqlMapper;

    @Override
    public List<UserMysqlBean> getMySQLUser() {
        return userMysqlMapper.getUser();
    }

    @Override
    public List<UserPgsqlBean> getPgsqlUser() {
        return userPgsqlMapper.getUser();
    }
}
