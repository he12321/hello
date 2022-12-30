package cn.he.day05;

import cn.he.JdbcTool.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
  练习：1.模拟商城中的登录：控制台中输入用户名、密码；能够进行登录。
 */
public class Demo1 {
    public static void main(String[] args)  {

        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名");
        String uname = input.next();
        System.out.println("请输入密码");
        String passwd = input.next();
        input.close();

        Connection con = null;
        Statement sta = null;
        ResultSet rs = null;
        try {
            con = JdbcUtil.getCon();
            System.out.println("加载驱动，建立连接成功！"+con);

            sta = con.createStatement();
            String sql = "select id,username,password,gender,salary from t_user where name = '" +uname
                    +"' and password = '"+passwd+"'";
            rs = sta.executeQuery(sql);
            if(rs.next()){
                System.out.println("登陆成功！正在跳转主页......");
            }
            else{
                System.out.println("登录失败，请重试！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {//关闭连接
            JdbcUtil.close(rs,sta,con);
        }
    }
}
