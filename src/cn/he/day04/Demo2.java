package cn.he.day04;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
    sql添加数据到mysql
 */
public class Demo2 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String className = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";
        String user = "root";//数据库的用户名
        String password = "123456";//数据库的密码
        Connection conn = null;
        //加载驱动
        Class.forName(className);
        System.out.println("驱动加载成功~~~");
        //创建连接
        try {
            conn = DriverManager.getConnection(url,user,password);
            System.out.println(conn + "建立连接");
            //Statement，语句对象，是用来发送sql并执行sql语句的
            //Statement createStatement() throws SQLException;
            Statement stat = conn.createStatement();
            //增删改----executeUpdate
            //int executeUpdate(String sql) throws SQLException;
            //返回值是int类型的额， 代表的是影响的行数。
            String sql = "insert into t_user(username,password,gender,salary) " +
                    "values('小贺','123456','女',30000)";
            int rows = stat.executeUpdate(sql);
            if (rows > 0){
                System.out.println("数据保存成功~~~");
            }else {
                System.out.println("请联系管理员~~");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
