package com.example.jpademo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author: Staro
 * @date: 2020/5/20 10:09
 * @Description:
 */
@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Long userId;
    private String province;
    private String city;
    private String street;
}
