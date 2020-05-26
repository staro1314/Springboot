package com.example.druiddemo.dao.mysql;

import com.example.druiddemo.pojo.UserMysqlBean;

import java.util.List;

/**
 * @author: Staro
 * @date: 2020/5/22 9:34
 * @Description:
 */
public interface UserMysqlMapper {
    List<UserMysqlBean> getUser();
}
