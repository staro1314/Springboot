package com.example.mybatisdemo.service;

import com.example.mybatisdemo.dao.UserMapper;
import com.example.mybatisdemo.dto.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: Staro
 * @date: 2020/5/21 17:10
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        List<User> all = userMapper.getAll();
        return all;
    }

    @Override
    public User getOne(Long id) {
        return userMapper.getOne(id);
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(Long id) {
        userMapper.delete(id);
    }
}
