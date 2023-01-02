package cn.he.JdbcTool;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/*
    �˹������װ��������mysql���ݿ�
 */
public class JdbcUtil {
    private static String classname;//���ݿ�5.6.50������jar8.0����
    private static String url;
    private static String user; //���ݿ��˺�
    private static String password; //���ݿ�����

    //��������
    static {
        try {
            //1.��ȡ�����ļ�������
            Properties properties = new Properties();
            //2.���������ļ����ڴ���
            properties.load(JdbcUtil.class.getClassLoader().getResourceAsStream("cn/he/JdbcTool/db.properties"));
            //3.����key��ȡvalue
            classname = properties.getProperty("classname");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            Class.forName(classname);//��������
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
    //��������
    public static Connection getCon() throws SQLException {
        Connection con = DriverManager.getConnection(url,user,password);
        return con;
    }
    public static Connection getCon(String datebasename) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/"+datebasename+"?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";
        Connection con = DriverManager.getConnection(url,user,password);
        return con;
    }
    //�ر��������ݿ�
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
