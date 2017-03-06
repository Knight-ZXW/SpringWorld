package com.zous.springworld.dao;

import com.zous.springworld.domain.User;

/**
 * Created by OnlyLoveForBelinda on 2016/4/12.
 */
public interface IUserDAO {

    public User queryOne(int id);
    public User insertUser(User user);
}
