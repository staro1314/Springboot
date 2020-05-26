package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.dto.User;
import com.example.mybatisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Staro
 * @date: 2020/5/21 17:08
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        return userService.getAll();
    }

    @RequestMapping("/getUser")
    public User getUser(Long id) {
        return userService.getOne(id);
    }

    @RequestMapping("/add")
    public void save(User user) {
        userService.insert(user);
    }

    @RequestMapping(value="update")
    public void update(User user) {
        userService.update(user);
    }

    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }


}
