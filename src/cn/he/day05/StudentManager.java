package cn.he.day05;

import cn.he.JdbcTool.JdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
/*
    学生信息管理系统
 */
public class StudentManager {
    public static void main(String[] args) {
        while(true){
            Scanner input = new Scanner(System.in);
            System.out.print("a:添加学生信息\t");
            System.out.print("b:查询所有学生信息\t");
            System.out.print("c:根据id修改学生信息\t");
            System.out.print("d:根据id删除学生信息\t");
            System.out.println("e:退出系统\t");
            System.out.println("请输入操作，abcde任选一项：");
            String a = input.nextLine();
            switch(a){
                case "a":addStu(); break;
                case "b":findAll(); break;
                case "c":updateStu(); break;
                case "d":deleteStu(); break;
                case "e":System.out.println("e.退出成功！");return;
                default:System.out.println("输入有误，请重新输入！");
            }
        }
    }
    public static void findAll(){//查询信息
        System.out.println("b.查询学生信息------>");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学号和姓名：");
        String stuid = sc.nextLine();
        String stuname = sc.nextLine();

        //要连接的数据库名字
        String database = "jt_db";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JdbcUtil.getCon(database);
            String sql  = "";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("加载驱动，连接"+con+"成功！");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
    public static void addStu(){
        System.out.println("a.添加学生信息------->");
        Scanner input = new Scanner(System.in);
        System.out.println("请输入学号：");
        String stuid = input.next();
        System.out.println("请输入名字：");
        String stuname = input.next();
        System.out.println("请输入性别：");
        String sex = input.next();
        System.out.println("请输入住址：");
        String stuaddr = input.next();
        System.out.println("请输入分数：");
        double score = input.nextDouble();

        //要连接的数据库名字
        String database = "jt_db";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JdbcUtil.getCon(database);
            System.out.println("加载驱动，连接"+con+"成功！");
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
                System.out.println("学生:"+stuname+"添加成功！");
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

    }

    public static void deleteStu() {//删除学生信息
        System.out.println("d.删除学生信息------>");

    }

}
