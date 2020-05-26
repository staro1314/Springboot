package com.example.mybatisdemo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: Staro
 * @date: 2020/5/21 16:59
 * @Description:
 */
@Setter
@Getter
@ToString
public class User {
    private Long id;
    private String userName;
    private String passWord;
    private String userSex;
    private String nickName;

    public User() {
        super();
    }

    public User(String userName, String passWord, String userSex) {
        super();
        this.passWord = passWord;
        this.userName = userName;
        this.userSex = userSex;
    }
}
