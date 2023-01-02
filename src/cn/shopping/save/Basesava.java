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
    设置一个基类
 */
public class Basesava {
    private static String databasename = "xzstore"; //要连接的数据库名字

    /*
          增/删/改/更新数据
          sql语句，占位符:? ? ?
          动态参数
     */
    public void updateData(String sql, Object ...parameters ) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        con = JdbcUtil.getCon(databasename);
        try {
            ps = con.prepareStatement(sql);
            //装载参数 参数下标从1开始
            for(int i=0;i<parameters.length;i++){
                ps.setObject(i+1,parameters[i]);//数组的下标从0开始
            }
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally{
            JdbcUtil.close(con,ps);
        }
    }
    /*
        查找数据
     */
    public ResultSet findData(String sql, Object...paramenters){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        CachedRowSet crs = null;//基于内存的结果表

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
            crs.populate(rs);//将结果集数据转存到基于内存的结果集中
            //public void populate(ResultSet data) throws SQLException;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(con, ps, rs);
        }
        return crs;//返回内存结果集
    }

}
