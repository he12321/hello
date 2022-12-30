package cn.he.JdbcTool;

import java.sql.*;

/*
    �˹������װ��������mysql���ݿ�
 */
public class JdbcUtil {
    private static String classname = "com.mysql.cj.jdbc.Driver";//���ݿ�5.6.50������jar8.0����
    private static String url = "jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";
    private static String user = "root";//���ݿ���û���
    private static String password = "123456";//���ݿ������

    //��������
    static {
        try {
            Class.forName(classname);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //��������
    public static Connection getCon() throws SQLException {
        Connection con = DriverManager.getConnection(url,user,password);
        return con;
    }
    //�ر��������ݿ�
    public static void close(ResultSet rs, Statement sta,Connection con){
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
