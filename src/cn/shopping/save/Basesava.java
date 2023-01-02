package cn.shopping.save;

import cn.he.JdbcTool.JdbcUtil;
import com.sun.rowset.CachedRowSetImpl;
import jdk.internal.util.xml.impl.ReaderUTF8;

import javax.sql.rowset.CachedRowSet;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
    ����һ������
 */
public class Basesava {
    private static String databasename = "xzstore"; //Ҫ���ӵ����ݿ�����

    /*
          ��/ɾ/��/��������
          sql��䣬ռλ��:? ? ?
          ��̬����
     */
    public void updateData(String sql, Object ...parameters ) throws SQLException {
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
    /*
        ��������
     */
    public ResultSet findData(String sql, Object...paramenters){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        CachedRowSet crs = null;//�����ڴ�Ľ����

        try {
            crs = new CachedRowSetImpl();
            con = JdbcUtil.getCon(databasename);
            ps = con.prepareStatement(sql);
            if (paramenters!=null){
                for (int i =0;i<paramenters.length;i++){
                    ps.setObject(i+1,paramenters[i]);
                }
            }
            rs = ps.executeQuery();
            crs.populate(rs);//�����������ת�浽�����ڴ�Ľ������
            //public void populate(ResultSet data) throws SQLException;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(con, ps, rs);
        }
        return crs;//�����ڴ�����
    }

}
