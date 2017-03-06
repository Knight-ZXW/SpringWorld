package com.zous.springworld.controller;

import com.zous.springworld.dao.UserDao;
import com.zous.springworld.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhuoxiuwu on 2017/3/5.
 */
@Controller
@RequestMapping("/api")
public class UserRouter {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/test",produces="application/json;charset=UTF-8")
    @ResponseBody
    public String HelloWorld(){
        User user = userDao.queryOne(1);

        return "hello "+user.getUserName();
    }
}
