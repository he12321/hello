package cn.he.day05;

import cn.he.JdbcTool.JdbcUtil;
import com.sun.deploy.security.SelectableSecurityManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/*
    学生信息管理系统
 */
public class StudentManager {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            System.out.print("a:添加学生信息\t");
            System.out.print("b:查询学生信息\t");
            System.out.print("c:根据id修改学生信息\t");
            System.out.print("d:根据id删除学生信息\t");
            System.out.println("e:退出系统\t");
            System.out.println("请输入操作，abcde任选一项：");
            String a = sc.next();
            switch(a){
                case "a":addStu(); break;
                case "b":selectStu(); break;
                case "c":updateStu(); break;
                case "d":deleteStu(); break;
                case "e":System.out.println("e.退出成功！");return;
                default:System.out.println("输入有误，请重新输入！");
            }
        }
    }

    public static void selectStu(){//查询信息
        System.out.println("b.查询学生信息------>");
        System.out.println("a.查询所有学生信息\tb.查询单个学生信息\tc.退出");
        String in = sc.next();

        //要连接的数据库名字
        String database = "jt_db";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if ("a".equals(in)) {
            try {
                con = JdbcUtil.getCon(database);
                String sql  = "select * from stu";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    String stuid = rs.getString("stuid");
                    String name = rs.getString("name");
                    String gender = rs.getString("gender");
                    String addr = rs.getString("addr");
                    double score = rs.getDouble("score");
                    System.out.println(stuid + ", " + name + ", " + gender + ", " + addr + ", " + score);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                JdbcUtil.close(con, ps, rs);
            }
        } else if ("b".equals(in)) {
            findStu();
        } else if ("c".equals(in)) {
            return;
        } else {
            System.out.println("你的输入有误，请重试！");
        }
    }

    public static void findStu(){
        System.out.println("请输入学号：");
        String stuid = sc.next();

        //要连接的数据库名字
        String database = "jt_db";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtil.getCon(database);
            String sql  = "select * from stu where stuid = ? ;";
            ps = con.prepareStatement(sql);
            ps.setString(1,stuid);
            rs = ps.executeQuery();
            if(rs.next()){
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String addr = rs.getString("addr");
                double score  = rs.getDouble("score");
                System.out.println("学号："+stuid);
                System.out.println("姓名："+name);
                System.out.println("性别："+gender);
                System.out.println("地址："+addr);
                System.out.println("分数："+score);
            } else{
                System.out.println("学号"+stuid+"学生不存在！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(con, ps, rs);
        }
    }
    
    public static void addStu(){
        System.out.println("a.添加学生信息------->");
        System.out.println("请输入学号：");
        String stuid = sc.next();
        System.out.println("请输入名字：");
        String stuname = sc.next();
        System.out.println("请输入性别：");
        String sex = sc.next();
        System.out.println("请输入住址：");
        String stuaddr = sc.next();
        System.out.println("请输入分数：");
        double score = sc.nextDouble();

        //要连接的数据库名字
        String database = "jt_db";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JdbcUtil.getCon(database);
            String sql = "insert into stu(stuid, name, gender, addr, score)" +
                    "values(?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql); //SQL骨架就已经确定了
            ps.setString(1,stuid);
            ps.setString(2,stuname);
            ps.setString(3,sex);
            ps.setString(4,stuaddr);
            ps.setDouble(5,score);
            int rows = ps.executeUpdate();
            if(rows>0){
                System.out.println("学生 "+stuname+" 添加成功！");
            }
            else{
                System.out.println("添加失败，请联系管理员！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(ps);
            JdbcUtil.close(con);
        }
    }

    public static void updateStu() {//修改学生信息
        System.out.println("c.修改学生信息------>");
        findStu();
        System.out.println("请输入要修改的学号、姓名、性别、地址、分数");
        String id = sc.next();
        String name = sc.next();
        String gender = sc.next();
        String addr = sc.next();
        double score = sc.nextDouble();

        //要连接的数据库名字
        String database = "jt_db";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
    }

    public static void deleteStu() {//删除学生信息
        System.out.println("d.删除学生信息------>");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的学生学号");
        String stuid = sc.next();

        //要连接的数据库名字
        String database = "jt_db";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JdbcUtil.getCon(database);
            String sql = "delete from stu where stuid = ?;";
            ps = con.prepareStatement(sql); //SQL骨架就已经确定了
            ps.setString(1,stuid);
            int rows = ps.executeUpdate();
            if (rows>0){
                System.out.println("id："+stuid+"信息删除成功！");
            }
            else{
                System.out.println("删除失败，请重试！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(con);
            JdbcUtil.close(ps);
        }
    }
}
