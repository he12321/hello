package cn.he.day04;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
    sql������ݵ�mysql
 */
public class Demo2 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String className = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";
        String user = "root";//���ݿ���û���
        String password = "123456";//���ݿ������
        Connection conn = null;
        //��������
        Class.forName(className);
        System.out.println("�������سɹ�~~~");
        //��������
        try {
            conn = DriverManager.getConnection(url,user,password);
            System.out.println(conn + "��������");
            //Statement������������������sql��ִ��sql����
            //Statement createStatement() throws SQLException;
            Statement stat = conn.createStatement();
            //��ɾ��----executeUpdate
            //int executeUpdate(String sql) throws SQLException;
            //����ֵ��int���͵Ķ �������Ӱ���������
            String sql = "insert into t_user(username,password,gender,salary) " +
                    "values('С��','123456','Ů',30000)";
            int rows = stat.executeUpdate(sql);
            if (rows > 0){
                System.out.println("���ݱ���ɹ�~~~");
            }else {
                System.out.println("����ϵ����Ա~~");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
