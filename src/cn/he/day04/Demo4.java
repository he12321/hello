package cn.he.day04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/*
    sql修改数据库内容
 */
public class Demo4 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String classname = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";
        String user = "root";
        String password = "123456";
        Connection con = null;

        //加载驱动
        Class.forName(classname);
        System.out.println("驱动加载成功！");
        //连接数据库
        con = DriverManager.getConnection(url,user,password);
        System.out.println(con+"数据库连接成功！");

        Statement sta = con.createStatement();
        String sql = "update t_user set password = 'java666' where id = 3";
        int rows = sta.executeUpdate(sql);
        if (rows > 0){
            System.out.println("密码修改成功！");
        }
        else{
            System.out.println("密码修改失败，请联系管理员！");
        }
    }
}
