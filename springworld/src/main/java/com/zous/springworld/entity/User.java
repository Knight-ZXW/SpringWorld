package com.zous.springworld.entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by OnlyLoveForBelinda on 2016/4/12.
 */
public class User {

    private int userId;
    private String name;
    private String password;
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
