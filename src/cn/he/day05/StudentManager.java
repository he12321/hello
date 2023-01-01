package cn.he.day05;

import cn.he.JdbcTool.JdbcUtil;
import com.sun.deploy.security.SelectableSecurityManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/*
    ѧ����Ϣ����ϵͳ
 */
public class StudentManager {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            System.out.print("a:���ѧ����Ϣ\t");
            System.out.print("b:��ѯѧ����Ϣ\t");
            System.out.print("c:����id�޸�ѧ����Ϣ\t");
            System.out.print("d:����idɾ��ѧ����Ϣ\t");
            System.out.println("e:�˳�ϵͳ\t");
            System.out.println("�����������abcde��ѡһ�");
            String a = sc.next();
            switch(a){
                case "a":addStu(); break;
                case "b":selectStu(); break;
                case "c":updateStu(); break;
                case "d":deleteStu(); break;
                case "e":System.out.println("e.�˳��ɹ���");return;
                default:System.out.println("�����������������룡");
            }
        }
    }

    public static void selectStu(){//��ѯ��Ϣ
        System.out.println("b.��ѯѧ����Ϣ------>");
        System.out.println("a.��ѯ����ѧ����Ϣ\tb.��ѯ����ѧ����Ϣ\tc.�˳�");
        String in = sc.next();

        //Ҫ���ӵ����ݿ�����
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
            System.out.println("����������������ԣ�");
        }
    }

    public static void findStu(){
        System.out.println("������ѧ�ţ�");
        String stuid = sc.next();

        //Ҫ���ӵ����ݿ�����
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
                System.out.println("ѧ�ţ�"+stuid);
                System.out.println("������"+name);
                System.out.println("�Ա�"+gender);
                System.out.println("��ַ��"+addr);
                System.out.println("������"+score);
            } else{
                System.out.println("ѧ��"+stuid+"ѧ�������ڣ�");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(con, ps, rs);
        }
    }
    
    public static void addStu(){
        System.out.println("a.���ѧ����Ϣ------->");
        System.out.println("������ѧ�ţ�");
        String stuid = sc.next();
        System.out.println("���������֣�");
        String stuname = sc.next();
        System.out.println("�������Ա�");
        String sex = sc.next();
        System.out.println("������סַ��");
        String stuaddr = sc.next();
        System.out.println("�����������");
        double score = sc.nextDouble();

        //Ҫ���ӵ����ݿ�����
        String database = "jt_db";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JdbcUtil.getCon(database);
            String sql = "insert into stu(stuid, name, gender, addr, score)" +
                    "values(?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql); //SQL�Ǽܾ��Ѿ�ȷ����
            ps.setString(1,stuid);
            ps.setString(2,stuname);
            ps.setString(3,sex);
            ps.setString(4,stuaddr);
            ps.setDouble(5,score);
            int rows = ps.executeUpdate();
            if(rows>0){
                System.out.println("ѧ�� "+stuname+" ��ӳɹ���");
            }
            else{
                System.out.println("���ʧ�ܣ�����ϵ����Ա��");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(ps);
            JdbcUtil.close(con);
        }
    }

    public static void updateStu() {//�޸�ѧ����Ϣ
        System.out.println("c.�޸�ѧ����Ϣ------>");
        findStu();
        System.out.println("������Ҫ�޸ĵ�ѧ�š��������Ա𡢵�ַ������");
        String id = sc.next();
        String name = sc.next();
        String gender = sc.next();
        String addr = sc.next();
        double score = sc.nextDouble();

        //Ҫ���ӵ����ݿ�����
        String database = "jt_db";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
    }

    public static void deleteStu() {//ɾ��ѧ����Ϣ
        System.out.println("d.ɾ��ѧ����Ϣ------>");
        Scanner sc = new Scanner(System.in);
        System.out.println("������Ҫɾ����ѧ��ѧ��");
        String stuid = sc.next();

        //Ҫ���ӵ����ݿ�����
        String database = "jt_db";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JdbcUtil.getCon(database);
            String sql = "delete from stu where stuid = ?;";
            ps = con.prepareStatement(sql); //SQL�Ǽܾ��Ѿ�ȷ����
            ps.setString(1,stuid);
            int rows = ps.executeUpdate();
            if (rows>0){
                System.out.println("id��"+stuid+"��Ϣɾ���ɹ���");
            }
            else{
                System.out.println("ɾ��ʧ�ܣ������ԣ�");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(con);
            JdbcUtil.close(ps);
        }
    }
}
