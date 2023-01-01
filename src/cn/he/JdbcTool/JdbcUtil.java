package cn.he.JdbcTool;

import java.sql.*;

/*
    此工具类封装用以连接mysql数据库
 */
public class JdbcUtil {
    private static String classname = "com.mysql.cj.jdbc.Driver";//数据库5.6.50，驱动jar8.0以上
    private static String url = "jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";
    private static String user = "root";//数据库的用户名
    private static String password = "h123456";//数据库的密码

    //加载驱动
    static {
        try {
            Class.forName(classname);
        } catch (ClassNotFoundException e) {
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
