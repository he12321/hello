package cn.he.day05;

import cn.he.JdbcTool.JdbcUtil;


import java.sql.*;
import java.util.Scanner;

public class Demo4 {
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
        try {
            con = JdbcUtil.getCon();
            System.out.println("驱动加载，数据库连接"+con+"成功！");
            String sql = "insert into t_user(username, password, gender, salary)"+
                    "values(?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,uname);
            ps.setString(2,passwd);
            ps.setString(3,sex);
            ps.setDouble(4,salary);
            int rows = ps.executeUpdate();
            if(rows>0){
                System.out.println("用户:"+uname+"注册成功！");
            }
            else{
                System.out.println("注册失败，请联系管理员！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
