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
    public static void main(String[] args) {

        //1��2��Day-5demo

        Connection con = null;
        try {
            con = JdbcUtil.getCon();
            System.out.println(con);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
