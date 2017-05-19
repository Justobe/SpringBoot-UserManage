package com.adc.gim.dao;

import com.adc.gim.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * Created by YanMing on 2017/5/17.
 */
@Transactional
public interface UserDao extends JpaRepository<User,Long>{
    public User findByEmail(String email);
    public User findByUsername(String name);

}
