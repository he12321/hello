package cn.he.day04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/*
    删除mysql里面的数据
 */
public class Demo3 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String classname = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";
        String user = "root";
        String password = "123456";
        Connection con = null;

        //加载驱动
        Class.forName(classname);
        System.out.println("驱动加载成功！");
        con = DriverManager.getConnection(url,user,password);
        Statement sta = con.createStatement();
        String sql = "delete from t_user where id = 22";
        int rows = sta.executeUpdate(sql);
        if(rows>0){
            System.out.println("删除账号成功");
        }
        else{
            System.out.println("删除失败！请重试或联系管理员！");
        }


    }
}
