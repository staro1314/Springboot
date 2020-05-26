package com.example.jpademo.service;

import com.example.jpademo.model.UserDetail;
import com.example.jpademo.pojo.UserDetailBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author: Staro
 * @date: 2020/5/20 10:20
 * @Description:
 */
public interface UserDetailService {
    public Page<UserDetail> findByCondition(UserDetailBean detailBean, Pageable pageable);;
}
