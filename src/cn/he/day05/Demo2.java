package cn.he.day05;

import cn.he.JdbcTool.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("�������û���");
        String uname = input.next();
        System.out.println("����������");
        String passwd = input.next();
        System.out.println("�������Ա�");
        String sex = input.next();
        System.out.println("������н�ʣ�");
        double salary = input.nextDouble();
        input.close();

        Connection con = null;
        Statement sta = null;
        ResultSet rs = null;
        try {
            con = JdbcUtil.getCon();
            sta = con.createStatement();
            String sql = "insert into t_user(username, password, gender, salary) " +
                    "values ('"+uname+"', '"+passwd+"', '"+sex+"', '"+salary+"')";
            int rows = sta.executeUpdate(sql);
            if(rows>0){
                System.out.println(uname+"ע��ɹ���");
            }
            else{
                System.out.println("ע��ʧ�ܣ�");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(con,sta,rs);
        }


    }
}
