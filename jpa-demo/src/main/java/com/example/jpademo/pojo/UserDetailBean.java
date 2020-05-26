package com.example.jpademo.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: Staro
 * @date: 2020/5/20 10:08
 * @Description:
 */
@Getter
@Setter
public class UserDetailBean {
    private String userId;
    private Integer minAge;
    private Integer maxAge;
    private String realName;
    private String introduction;
    private String city;
}
