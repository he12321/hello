package cn.he.day04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo3 {
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
        String sql = "delete from t_user where id = 2";
        int rows = sta.executeUpdate(sql);
        if(rows>0){
            System.out.println("ɾ���˺ųɹ�");
        }
        else{
            System.out.println("ɾ��ʧ�ܣ������Ի���ϵ����Ա��");
        }


    }
}
