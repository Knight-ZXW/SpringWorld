package com.zous.springworld.service;

import com.zous.springworld.entity.User;
import com.zous.springworld.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhuoxiuwu on 2017/3/10.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User registerUser(User user) {
        userMapper.insertUser(user);
        return user;
    }

    public User selectUser(int id) {
        return userMapper.selectUser(1);
    }

}
