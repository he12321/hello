package cn.he.day05;

import cn.he.JdbcTool.JdbcUtil;


import java.sql.*;
import java.util.Scanner;

public class Demo4 {
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
        try {
            con = JdbcUtil.getCon();
            System.out.println("�������أ����ݿ�����"+con+"�ɹ���");
            String sql = "insert into t_user(username, password, gender, salary)"+
                    "values(?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,uname);
            ps.setString(2,passwd);
            ps.setString(3,sex);
            ps.setDouble(4,salary);
            int rows = ps.executeUpdate();
            if(rows>0){
                System.out.println("�û�:"+uname+"ע��ɹ���");
            }
            else{
                System.out.println("ע��ʧ�ܣ�����ϵ����Ա��");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
