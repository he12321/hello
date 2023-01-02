package cn.shopping.test;

import cn.shopping.entity.User;
import cn.shopping.save.Usersave;
import org.junit.jupiter.api.Test;

import java.beans.Transient;
import java.sql.SQLException;

public class TestUsersave {

    @Test//添加用户
    public void testSave() {
        User user = new User();
        user.setUsername("凯人");
        user.setPassword("hello2023");
        user.setPhone("18807232323");
        user.setEmail("132456789@qq.com");
        Usersave us = new Usersave();
        try {
            us.savaUser(user);//保存用户
            System.out.println("添加用户"+user.getUsername()+"成功!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test//修改密码
    public void testUpdatepwd(){
        int id = 49;//修改id对应的用户密码
        String newpwd = "a132456";//新密码
        Usersave us = new Usersave();
        try {
            us.updatePwd(id,newpwd);
            System.out.println("密码修改成功！");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test//修改手机号、邮箱
    public void testUpdateEmail(){
        User user = new User();
        user.setId(25);//要修改用户id
        user.setEmail("12346567@tencent.com");
        user.setPhone("18812341234");
        try {
            new Usersave().updateEmail(user);
            System.out.println(user.getId()+" 手机号、邮箱修改成功！");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test//修改用户名
    public void testUpdateUsername(){
        int id = 1;//要修改的id
        String newname = "helloworld";//用户名
        Usersave us = new Usersave();
        try {
            us.updateUsername(id,newname);
            System.out.println("id:"+id+" 用户名修改成功！");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}