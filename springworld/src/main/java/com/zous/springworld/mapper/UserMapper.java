package com.zous.springworld.mapper;

import com.zous.springworld.entity.User;

/**
 * Created by zhuoxiuwu on 2017/3/6.
 * see /resource/mapper
 */
public interface UserMapper {
    User selectUser(int id);
    int insertUser(User user);
}
