package com.example.jpademo.repository;

import com.example.jpademo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: Staro
 * @date: 2020/5/20 10:14
 * @Description:
 */
public interface AddressRepository extends JpaRepository<Address,Long> {
}
