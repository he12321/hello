package cn.he.day05;

import cn.he.JdbcTool.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
  ��ϰ��1.ģ���̳��еĵ�¼������̨�������û��������룻�ܹ����е�¼��
 */
public class Demo1 {
    public static void main(String[] args)  {

        Scanner input = new Scanner(System.in);
        System.out.println("�������û���");
        String uname = input.next();
        System.out.println("����������");
        String passwd = input.next();
        input.close();

        Connection con = null;
        Statement sta = null;
        ResultSet rs = null;
        try {
            con = JdbcUtil.getCon();
            System.out.println("�����������������ӳɹ���"+con);

            sta = con.createStatement();
            String sql = "select id,username,password,gender,salary from t_user where name = '" +uname
                    +"' and password = '"+passwd+"'";
            rs = sta.executeQuery(sql);
            if(rs.next()){
                System.out.println("��½�ɹ���������ת��ҳ......");
            }
            else{
                System.out.println("��¼ʧ�ܣ������ԣ�");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {//�ر�����
            JdbcUtil.close(rs,sta,con);
        }
    }
}
