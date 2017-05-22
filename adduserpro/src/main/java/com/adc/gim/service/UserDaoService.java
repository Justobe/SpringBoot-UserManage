package com.adc.gim.service;

import com.adc.gim.dao.UserDao;
import com.adc.gim.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by YanMing on 2017/5/22.
 */
@Service
public class UserDaoService {
    @Autowired
    UserDao userDao;
    public User findByEmail(String email){
        return userDao.findByEmail(email);
    }
    public User findByUsername(String name){
        return userDao.findByUsername(name);
    }
    public User save(User user){
        return userDao.save(user);
    }
}
