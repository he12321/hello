package cn.shopping.save;

import cn.shopping.entity.User;

import java.sql.SQLException;

public class Usersave extends Basesava {

    //�����û���Ϣ
    public void savaUser(User user) throws SQLException {
        String sql = "insert into t_user(username,password,phone,email,created,updated) values(?,?,?,?,NOW(),NOW())";
        this.updateData(sql,user.getUsername(),user.getPassword(),user.getPhone(),user.getEmail());
    }


    //�޸�id��Ӧ������
    public void updatePwd(int id, String newpsswd) throws SQLException {
        String sql = "update t_user set password = ? where id = ?;";
        this.updateData(sql, newpsswd, id);
    }

    //�޸�id��Ӧ������ź��ֻ�
    public void updateEmail(User user) throws SQLException {
        String sql = "update t_user set phone = ?, email = ? where id = ?;";
        this.updateData(sql,user.getPhone(),user.getEmail(),user.getId());
    }

    //�޸�id��Ӧ���û���
    public void updateUsername(int id, String newname) throws SQLException {
        String sql = "update t_user set username = ? where id = ?;";
        this.updateData(sql,newname,id);
    }
}
