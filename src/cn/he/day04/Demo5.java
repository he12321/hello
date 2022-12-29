package cn.he.day04;

import java.sql.*;

public class Demo5 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String classname = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "123456";
        Connection con = null;

        //加载驱动
        Class.forName(classname);
        System.out.println("驱动加载成功！");
        con = DriverManager.getConnection(url,user,password);

        Statement sta = con.createStatement();
        String sql = "select id,username,password,gender,salary from t_user";
        /*查询的时候：executeQuery
        发送select语句
        ResultSet executeQuery(String sql) throws SQLException;
        返回结果是采集对象ResultSet
         */
        //处理结果集对象
        ResultSet rs = sta.executeQuery(sql);
        while(rs.next()){
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String gender = rs.getString("gender");
            double salary = rs.getDouble("salary");
            System.out.println("id:"+id+", "+username+" 性别:"+gender+" 月薪:"+salary);
        }
    }
}

