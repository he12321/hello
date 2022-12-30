package cn.he.day05;

import cn.he.JdbcTool.JdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
/*
    ѧ����Ϣ����ϵͳ
 */
public class StudentManager {
    public static void main(String[] args) {
        while(true){
            Scanner input = new Scanner(System.in);
            System.out.print("a:��ѯ����ѧ����Ϣ\t");
            System.out.print("b:���ѧ����Ϣ\t");
            System.out.print("c:����id�޸�ѧ����Ϣ\t");
            System.out.print("d:����idɾ��ѧ����Ϣ\t");
            System.out.println("e:�˳�ϵͳ\t");
            System.out.println("�����������abcde��ѡһ�");
            String a = input.next();
            switch(a){
                case "a":findAll(); break;
                case "b":addStu(); break;
                case "c":updateStu(); break;
                case "d":deleteStu(); break;
                case "e":System.out.println("e.�˳��ɹ���");return;
                default:System.out.println("�����������������룡");
            }
        }
    }
    public static void findAll(){//��ѯ��Ϣ
        System.out.println("a.��ѯѧ����Ϣ------>");

    }
    public static void addStu(){
        System.out.println("b.���ѧ����Ϣ------->");
        Scanner input = new Scanner(System.in);
        System.out.println("������ѧ�ţ�");
        String stuid = input.next();
        System.out.println("���������֣�");
        String stuname = input.next();
        System.out.println("�������Ա�");
        String sex = input.next();
        System.out.println("������סַ��");
        String stuaddr = input.next();
        System.out.println("�����������");
        double score = input.nextDouble();
        input.close();

        String database = "jt_db";   //Ҫ���ӵ����ݿ�����
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JdbcUtil.getCon(database);
            System.out.println("��������������"+con+"�ɹ���");
            String sql = "insert into stu(stuid, name, gender, addr, score)" +
                    "values(?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,stuid);
            ps.setString(2,stuname);
            ps.setString(3,sex);
            ps.setString(4,stuaddr);
            ps.setDouble(5,score);
            int rows = ps.executeUpdate();
            if(rows>0){
                System.out.println("ѧ��:"+stuname+"��ӳɹ���");
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

    }
    public static void deleteStu() {//ɾ��ѧ����Ϣ
        System.out.println("d.ɾ��ѧ����Ϣ------>");

    }

}
