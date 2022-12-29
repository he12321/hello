package cn.he.day04;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
    ??t_user????????????????
 */
public class Demo2 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String className = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC";
        String user = "root";//???????????
        String password = "123456";//??????????
        Connection conn = null;
        //????????
        Class.forName(className);
        System.out.println("??????????!!");
        //????????
        try {
            conn = DriverManager.getConnection(url,user,password);
            System.out.println(conn + "????????");
            //Statement??????????????????sql?????sql????
            //Statement createStatement() throws SQLException;
            Statement stat = conn.createStatement();
            //?????----executeUpdate
            //int executeUpdate(String sql) throws SQLException;
            //???????int?????? ?????????????????
            String sql = "insert into t_user(username,password,gender,salary) " +
                    "values('liuyueling','123456','?',30000)";
            int rows = stat.executeUpdate(sql);
            if (rows > 0){
                System.out.println("?????????~~~");
            }else {
                System.out.println("??????????~~");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
