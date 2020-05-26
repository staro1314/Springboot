package com.example.mybatisdemo.service;

import com.example.mybatisdemo.dto.User;

import java.util.List;

/**
 * @author: Staro
 * @date: 2020/5/21 17:09
 * @Description:
 */
public interface UserService {
    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);
}
