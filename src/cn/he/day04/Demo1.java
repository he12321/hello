package cn.he.day04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
    JDBC：加载驱动
 */
public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //mysql 8.0以上 com.mysql.cj.jdbc.Driver
        //加载驱动类
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("驱动加载成功！");

        //建立连接
        /*
        jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8","root","123456"
        url：http://www.baidu.com 数据库的地址
        jdbc:mysql 设置驱动程序类的
        localhost：主机名或ip地址
         */
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8","root","123456");
        System.out.println("连接"+con+"成功");
        //Statement:语句对象，用来发送sql并执行sql语句的
        Statement state = con.createStatement();

        long start = System.currentTimeMillis();
        //建立连接（连接对象内部其实包含一个Socket对象，是一个远程连接，比较耗时，这是Connection管理的一个要点！）
        //真正开发过程中，为了提高效率，都会使用连接池来管理连接对象
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC", "root", "123456");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("总共耗时：" + (end - start) + "毫秒");

    }
}
