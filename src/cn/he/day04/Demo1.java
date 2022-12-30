package cn.he.day04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
    JDBC����������
 */
public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //mysql 8.0���� com.mysql.cj.jdbc.Driver
        //����������
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("�������سɹ���");

        //��������
        /*
        jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8","root","123456"
        url��http://www.baidu.com ���ݿ�ĵ�ַ
        jdbc:mysql ���������������
        localhost����������ip��ַ
         */
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8","root","123456");
        System.out.println("����"+con+"�ɹ�");
        //Statement:��������������sql��ִ��sql����
        Statement state = con.createStatement();

        long start = System.currentTimeMillis();
        //�������ӣ����Ӷ����ڲ���ʵ����һ��Socket������һ��Զ�����ӣ��ȽϺ�ʱ������Connection�����һ��Ҫ�㣡��
        //�������������У�Ϊ�����Ч�ʣ�����ʹ�����ӳ����������Ӷ���
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC", "root", "123456");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("�ܹ���ʱ��" + (end - start) + "����");

    }
}
