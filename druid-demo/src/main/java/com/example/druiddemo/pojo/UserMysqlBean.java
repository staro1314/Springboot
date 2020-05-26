package com.example.druiddemo.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: Staro
 * @date: 2020/5/22 11:40
 * @Description:
 */
@Setter
@Getter
@ToString
public class UserMysqlBean {
    private int id;
    private String username;
    private String password;
    private String sex;
    private String nickName;
}
