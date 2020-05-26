package com.example.druiddemo.dao.pgsql;

import com.example.druiddemo.pojo.UserPgsqlBean;

import java.util.List;

/**
 * @author: Staro
 * @date: 2020/5/22 11:05
 * @Description:
 */
public interface UserPgsqlMapper {
    List<UserPgsqlBean> getUser();
}
