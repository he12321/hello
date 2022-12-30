package cn.he.day04;

import cn.he.JdbcTool.JdbcUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static cn.he.JdbcTool.JdbcUtil.getCon;

/*
   练习：1.模拟商城中的登录：控制台中输入用户名、密码；能够进行登录。
        2.模拟商场的用户注册
 */
public class Demo6 {
    public static void main(String[] args) {

        //1、2见Day-5demo

        Connection con = null;
        try {
            con = JdbcUtil.getCon();
            System.out.println(con);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
