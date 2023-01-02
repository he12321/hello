package cn.shopping.save;

import cn.he.JdbcTool.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
    设置一个基类
 */
public class Basesava {
    /*
          增/删/改/查，更新数据
          sql语句，占位符:? ? ?
          动态参数
     */
    public void updateData(String sql, Object ...parameters ) throws SQLException {
        //要连接的数据库名字
        String databasename = "xzstore";
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

}
