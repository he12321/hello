package cn.shopping.save;

import cn.he.JdbcTool.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
    ����һ������
 */
public class Basesava {
    /*
          ��/ɾ/��/�飬��������
          sql��䣬ռλ��:? ? ?
          ��̬����
     */
    public void updateData(String sql, Object ...parameters ) throws SQLException {
        //Ҫ���ӵ����ݿ�����
        String databasename = "xzstore";
        Connection con = null;
        PreparedStatement ps = null;

        con = JdbcUtil.getCon(databasename);
        try {
            ps = con.prepareStatement(sql);
            //װ�ز��� �����±��1��ʼ
            for(int i=0;i<parameters.length;i++){
                ps.setObject(i+1,parameters[i]);//������±��0��ʼ
            }
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally{
            JdbcUtil.close(con,ps);
        }
    }

}
