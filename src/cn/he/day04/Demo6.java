package cn.he.day04;

import cn.he.JdbcTool.JdbcUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static cn.he.JdbcTool.JdbcUtil.getCon;

/*
   ��ϰ��1.ģ���̳��еĵ�¼������̨�������û��������룻�ܹ����е�¼��
        2.ģ���̳����û�ע��
 */
public class Demo6 {
    public static void Login() throws SQLException {
        while(true) {
            Scanner input = new Scanner(System.in);
            System.out.println("�������û���");
            String uname = input.next();
            Connection con = getCon();
            System.out.println("����������");
            String passwd = input.next();
        }

    }
}
