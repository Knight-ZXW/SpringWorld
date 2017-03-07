package com.zous.springworld.domain;

/**
 * Created by OnlyLoveForBelinda on 2016/4/12.
 */
public class User {

    private int id;
    private String name;
    private String password;
    private String lastVisit;
    private String lastIp;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(String lastVisit) {
        this.lastVisit = lastVisit;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", lastVisit='" + lastVisit + '\'' +
                ", lastIp='" + lastIp + '\'' +
                '}';
    }
}
