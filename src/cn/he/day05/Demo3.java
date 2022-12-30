package cn.he.day05;

import cn.he.JdbcTool.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
    为了防止SQL注入：
SQL注入即是指web应用程序对用户输入数据的合法性没有判断或过滤不严，
攻击者可以在web应用程序中事先定义好的查询语句的结尾上添加额外的SQL语句，
在管理员不知情的情况下实现非法操作，以此来实现欺骗数据库服务器执行非授权的任意查询，
从而进一步得到相应的数据信息
public interface PreparedStatement extends Statement {}
PreparedStatement：预处理语句对象，是Statemet的子接口
作用：
    1.避免sql注入：由于用户的输入改变了程序中的sql语义
    2.增强sql在程序中的可读性
    3.提高效率：同一条sql语句（装载参数sql语句）多次执行的效率
用法：
   sql中需要拼接java中的变量，使用?作为占位符的
   delete from t_user where id = ?
实例化：
   PreparedStatement ps = conn.prepareStatement(sql);
   比较：conn.createStatement();
   装载参数：
   setXXX();
   void setString(int parameterIndex, String x) throws SQLException;
   void setInt(int parameterIndex, int x) throws SQLException;
   parameterIndex ---占位符(?)的索引从1开始的。第一个问号的占位符的值就是1。
   int x ---要传的整型值
 */
public class Demo3 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JdbcUtil.getCon();
            System.out.println("驱动加载，数据库连接"+con+"成功！");
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
