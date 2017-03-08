package com.zous.springworld.mapper;

import com.zous.springworld.entity.User;

/**
 * Created by zhuoxiuwu on 2017/3/6.
 * 仅仅是实现抽象接口，具体的映射关系 卸载 mapper包下
 */
public interface UserMapper {
    User selectUser(int id);
}
