package cn.he.JdbcTool;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/*
    此工具类封装用以连接mysql数据库
 */
public class JdbcUtil {
    private static String classname;//数据库5.6.50，驱动jar8.0以上
    private static String url;
    private static String user; //数据库账号
    private static String password; //数据库密码

    //加载驱动
    static {
        try {
            //1.读取属性文件工具类
            Properties properties = new Properties();
            //2.加载属性文件到内存中
            properties.load(JdbcUtil.class.getClassLoader().getResourceAsStream("cn/he/JdbcTool/db.properties"));
            //3.根据key读取value
            classname = properties.getProperty("classname");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            Class.forName(classname);//加载驱动
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
    //建立连接
    public static Connection getCon() throws SQLException {
        Connection con = DriverManager.getConnection(url,user,password);
        return con;
    }
    public static Connection getCon(String datebasename) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/"+datebasename+"?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";
        Connection con = DriverManager.getConnection(url,user,password);
        return con;
    }
    //关闭连接数据库
    public static void close(Connection con, Statement sta, ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (sta!=null){
            try {
                sta.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (con!=null){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static void close(Connection con, Statement sta){
        if (sta!=null){
            try {
                sta.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (con!=null){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static void close(Connection con){
        if (con!=null){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static void close(ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static void close(Statement sta){
        if (sta!=null) {
            try {
                sta.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
