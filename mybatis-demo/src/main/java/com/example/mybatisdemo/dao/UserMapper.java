package com.example.mybatisdemo.dao;

import com.example.mybatisdemo.dto.User;

import java.util.List;

/**
 * @author: Staro
 * @date: 2020/5/21 16:43
 * @Description:
 */
public interface UserMapper {
    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);
}
