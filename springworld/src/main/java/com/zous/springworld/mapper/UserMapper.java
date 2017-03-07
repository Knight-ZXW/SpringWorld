package com.zous.springworld.mapper;

import com.zous.springworld.domain.User;
import org.apache.ibatis.annotations.Select;

/**
 * Created by zhuoxiuwu on 2017/3/6.
 */
public interface UserMapper {
    @Select("SELECT * FROM user where id = #{id}")
    User selectUser(int id);
}
