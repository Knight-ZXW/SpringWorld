package com.zous.springworld.test;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by zhuoxiuwu on 2017/3/10.
 */
public class TestMysql {
    public static final String url = "jdbc:mysql://127.0.0.1/world";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "root";

    public static Connection conn = null;
    public static PreparedStatement pst = null;

    public static void main(String[] args) {
        try {
            Class.forName(name);//指定连接类型
            conn = DriverManager.getConnection(url, user, password);//获取连接
            System.out.print(conn.getCatalog());
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
