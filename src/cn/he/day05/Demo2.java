package cn.he.day05;

import cn.he.JdbcTool.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名");
        String uname = input.next();
        System.out.println("请输入密码");
        String passwd = input.next();
        System.out.println("请输入性别：");
        String sex = input.next();
        System.out.println("请输入薪资：");
        double salary = input.nextDouble();
        input.close();

        Connection con = null;
        Statement sta = null;
        ResultSet rs = null;
        try {
            con = JdbcUtil.getCon();
            sta = con.createStatement();
            String sql = "insert into t_user(username, password, gender, salary) " +
                    "values ('"+uname+"', '"+passwd+"', '"+sex+"', '"+salary+"')";
            int rows = sta.executeUpdate(sql);
            if(rows>0){
                System.out.println(uname+"注册成功！");
            }
            else{
                System.out.println("注册失败！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(con,sta,rs);
        }


    }
}
