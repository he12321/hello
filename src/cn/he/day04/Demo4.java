package cn.he.day04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/*
    sql�޸����ݿ�����
 */
public class Demo4 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String classname = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";
        String user = "root";
        String password = "123456";
        Connection con = null;

        //��������
        Class.forName(classname);
        System.out.println("�������سɹ���");
        //�������ݿ�
        con = DriverManager.getConnection(url,user,password);
        System.out.println(con+"���ݿ����ӳɹ���");

        Statement sta = con.createStatement();
        String sql = "update t_user set password = 'java666' where id = 3";
        int rows = sta.executeUpdate(sql);
        if (rows > 0){
            System.out.println("�����޸ĳɹ���");
        }
        else{
            System.out.println("�����޸�ʧ�ܣ�����ϵ����Ա��");
        }
    }
}
