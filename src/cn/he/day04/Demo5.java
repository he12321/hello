package cn.he.day04;

import java.sql.*;

public class Demo5 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String classname = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "123456";
        Connection con = null;

        //��������
        Class.forName(classname);
        System.out.println("�������سɹ���");
        con = DriverManager.getConnection(url,user,password);

        Statement sta = con.createStatement();
        String sql = "select id,username,password,gender,salary from t_user";
        /*��ѯ��ʱ��executeQuery
        ����select���
        ResultSet executeQuery(String sql) throws SQLException;
        ���ؽ���ǲɼ�����ResultSet
         */
        //������������
        ResultSet rs = sta.executeQuery(sql);
        while(rs.next()){
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String gender = rs.getString("gender");
            double salary = rs.getDouble("salary");
            System.out.println("id:"+id+", "+username+" �Ա�:"+gender+" ��н:"+salary);
        }
    }
}

