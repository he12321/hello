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
    public static void Login() throws SQLException {
        while(true) {
            Scanner input = new Scanner(System.in);
            System.out.println("请输入用户名");
            String uname = input.next();
            Connection con = getCon();
            System.out.println("请输入密码");
            String passwd = input.next();
        }

    }
}
