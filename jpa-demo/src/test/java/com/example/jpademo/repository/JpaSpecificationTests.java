package com.example.jpademo.repository;

import com.example.jpademo.model.UserDetail;
import com.example.jpademo.pojo.UserDetailBean;
import com.example.jpademo.service.UserDetailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author: Staro
 * @date: 2020/5/20 14:59
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaSpecificationTests {
    @Resource
    private UserDetailService userDetailService;

    @Test
    public void testFindByCondition()  {
        int page=0,size=10;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        UserDetailBean param=new UserDetailBean();
        param.setIntroduction("程序员");
        param.setMinAge(10);
        param.setMaxAge(30);
        Page<UserDetail> page1=userDetailService.findByCondition(param,pageable);
        for (UserDetail userDetail:page1){
            System.out.println("userDetail: "+userDetail.toString());
        }
    }
}
