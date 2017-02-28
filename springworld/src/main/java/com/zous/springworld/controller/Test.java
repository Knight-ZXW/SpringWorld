package com.zous.springworld.controller;

import com.zous.springworld.dao.IUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by OnlyLoveForBelinda on 2016/4/12.
 */
@Controller
@RequestMapping("/studyabroad/test")
public class Test {

    @Autowired
    private IUserDAO userDAO ;

    @RequestMapping(value = "/helloworld")
    public String HelloWorld(){
        System.out.println(userDAO.queryOne(1));
        return "success" ;
    }
}
