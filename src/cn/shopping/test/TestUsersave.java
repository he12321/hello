package cn.shopping.test;

import cn.shopping.entity.User;
import cn.shopping.save.Usersave;
import org.junit.jupiter.api.Test;

import java.beans.Transient;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TestUsersave {

    @Test//����û�
    public void testSave() {
        User user = new User();
        user.setUsername("����");
        user.setPassword("hello2023");
        user.setPhone("18807232323");
        user.setEmail("132456789@qq.com");
        Usersave us = new Usersave();
        try {
            us.savaUser(user);//�����û�
            System.out.println("����û�"+user.getUsername()+"�ɹ�!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test//�޸�����
    public void testUpdatepwd(){
        int id = 49;//�޸�id��Ӧ���û�����
        String newpwd = "a132456";//������
        Usersave us = new Usersave();
        try {
            us.updatePwd(id,newpwd);
            System.out.println("�����޸ĳɹ���");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test//�޸��ֻ��š�����
    public void testUpdateEmail(){
        User user = new User();
        user.setId(25);//Ҫ�޸��û�id
        user.setEmail("12346567@tencent.com");
        user.setPhone("18812341234");
        try {
            new Usersave().updateEmail(user);
            System.out.println(user.getId()+" �ֻ��š������޸ĳɹ���");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test//�޸��û���
    public void testUpdateUsername(){
        int id = 1;//Ҫ�޸ĵ�id
        String newname = "helloworld";//�û���
        Usersave us = new Usersave();
        try {
            us.updateUsername(id,newname);
            System.out.println("id:"+id+" �û����޸ĳɹ���");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test//��ѯ�û�
    public void testfindByUser(){
        Usersave us = new Usersave();
        try {
            User user = us.findByUser("����","hello2023");
            System.out.println(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test//��ѯ�����Ƿ�ע��
    public void testfindByemail(){
        Usersave us = new Usersave();
        boolean result = false;
        try {
            result = us.findByemail("123");
            if (result){
                System.out.println("�������Ѿ���ע�ᣡ");
            }
            else{
                System.out.println("���������ע�ᣡ");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test//��ѯ�ֻ��Ƿ�ע��
    public void testfindByphone() {
        Usersave us = new Usersave();
        boolean result = false;
        try {
            result = us.findByphone("110");
            if (result) {
                System.out.println("���ֻ����Ѿ���ע�ᣡ");
            } else {
                System.out.println("���ֻ�����ע�ᣡ");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test//��ѯ���е��û���Ϣ
    public void testfindAll(){
        Usersave us = new Usersave();
        List<User> list = us.findAll();
        for (User user: list ) {
            System.out.println(user);
        }
    }

}