package com.zous.springworld.web;

import com.zous.rest.Result;
import com.zous.springworld.entity.User;
import com.zous.springworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Created by zhuoxiuwu on 2017/3/5.
 */
@Controller
@RequestMapping("/api")
public class UserApi {
    @Autowired
    private UserService userService;
    Logger logger = Logger.getLogger(getClass().getSimpleName());

    @RequestMapping(value = "/test")
    @ResponseBody
    public User HelloWorld(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("testKey", "testValue");
        User user = userService.selectUser(1);
        response.addCookie(new Cookie("testCookie", "testCookieValue"));
        return user;
    }


    @RequestMapping(value = "/register",
            method = RequestMethod.POST)
    @ResponseBody
    public Result register(String userName, String pwd, HttpServletRequest request) {
        User user = new User();
        user.setName(userName);
        user.setPassword(pwd);
        userService.registerUser(user);
        request.getSession().setAttribute("user", user);
        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        users.add(user);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("users",users);
        return Result.ok(users);
    }

    @RequestMapping(value = "whoIam", method = RequestMethod.GET)
    @ResponseBody
    public Result<User> whoIam(HttpServletRequest request) {
        return Result.ok((User) request.getSession().getAttribute("user"));
    }

    @RequestMapping(value = "logout", method = RequestMethod.DELETE)
    @ResponseBody
    public Result logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return Result
                .ok()
                .setMessage("退出成功");
    }
}
