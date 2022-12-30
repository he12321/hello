package cn.he.day05;

import cn.he.JdbcTool.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
    Ϊ�˷�ֹSQLע�룺
SQLע�뼴��ָwebӦ�ó�����û��������ݵĺϷ���û���жϻ���˲��ϣ�
�����߿�����webӦ�ó��������ȶ���õĲ�ѯ���Ľ�β����Ӷ����SQL��䣬
�ڹ���Ա��֪��������ʵ�ַǷ��������Դ���ʵ����ƭ���ݿ������ִ�з���Ȩ�������ѯ��
�Ӷ���һ���õ���Ӧ��������Ϣ
public interface PreparedStatement extends Statement {}
PreparedStatement��Ԥ������������Statemet���ӽӿ�
���ã�
    1.����sqlע�룺�����û�������ı��˳����е�sql����
    2.��ǿsql�ڳ����еĿɶ���
    3.���Ч�ʣ�ͬһ��sql��䣨װ�ز���sql��䣩���ִ�е�Ч��
�÷���
   sql����Ҫƴ��java�еı�����ʹ��?��Ϊռλ����
   delete from t_user where id = ?
ʵ������
   PreparedStatement ps = conn.prepareStatement(sql);
   �Ƚϣ�conn.createStatement();
   װ�ز�����
   setXXX();
   void setString(int parameterIndex, String x) throws SQLException;
   void setInt(int parameterIndex, int x) throws SQLException;
   parameterIndex ---ռλ��(?)��������1��ʼ�ġ���һ���ʺŵ�ռλ����ֵ����1��
   int x ---Ҫ��������ֵ
 */
public class Demo3 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JdbcUtil.getCon();
            System.out.println("�������أ����ݿ�����"+con+"�ɹ���");
            String sql = "delete from t_user where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,5);
            int rows = ps.executeUpdate();
            System.out.println(rows);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(con);
            JdbcUtil.close(ps);
        }

    }
}
