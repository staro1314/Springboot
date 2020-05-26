package com.example.jpademo.service.impl;

import com.example.jpademo.model.UserDetail;
import com.example.jpademo.pojo.UserDetailBean;
import com.example.jpademo.repository.UserDetailRepository;
import com.example.jpademo.service.UserDetailService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


/**
 * @author: Staro
 * @date: 2020/5/20 10:21
 * @Description:
 */
@Service
public class UserDetailServiceImpl implements UserDetailService {
    @Resource
    private UserDetailRepository userDetailRepository;


    @Override
    public Page<UserDetail> findByCondition(UserDetailBean detailParam, Pageable pageable){

        return userDetailRepository.findAll((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();
            //equal 示例
            if (StringUtils.isNotEmpty(detailParam.getIntroduction())){
                predicates.add(cb.equal(root.get("introduction"),detailParam.getIntroduction()));
            }
            //like 示例
            if (StringUtils.isNotEmpty(detailParam.getRealName())){
                predicates.add(cb.like(root.get("realName"),"%"+detailParam.getRealName()+"%"));
            }
            //between 示例
            if (detailParam.getMinAge()!=null && detailParam.getMaxAge()!=null) {
                Predicate agePredicate = cb.between(root.get("age"), detailParam.getMinAge(), detailParam.getMaxAge());
                predicates.add(agePredicate);
            }
            //greaterThan 大于等于示例
            if (detailParam.getMinAge()!=null){
                predicates.add(cb.greaterThan(root.get("age"),detailParam.getMinAge()));
            }
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        }, pageable);

    }
}
