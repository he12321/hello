package cn.he.day05;

import cn.he.JdbcTool.JdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("�û�����");
        String username = sc.next();
        System.out.println("���룺");
        String pwd = sc.next();
        sc.close();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getCon();
            String sql = "select * from t_user where username=? and password=?";
            ps = conn.prepareStatement(sql);//SQL�Ǽܾ��Ѿ�ȷ����
            //װ�ز���
            ps.setString(1, username);
            ps.setString(2,pwd);
            rs = ps.executeQuery();
            if (rs.next()){
                System.out.println("��¼�ɹ���������ת��ҳ....");
            }else {
                System.out.println("�û��������������...");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(rs,ps,conn);
        }
    }
}
