package com.zous.springworld.web;

import com.zous.springworld.entity.User;
import com.zous.springworld.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhuoxiuwu on 2017/3/5.
 */
@Controller
@RequestMapping("/api")
public class UserApi {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/test",produces="application/json;charset=UTF-8")
    @ResponseBody
    public String HelloWorld(){
        User user = userMapper.selectUser(1);
        return user+"";
    }
}
