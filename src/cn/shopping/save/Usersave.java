package cn.shopping.save;

import cn.he.JdbcTool.JdbcUtil;
import cn.shopping.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    //--��ѯ--�����û�������û�����username�������루password��
    public User findByUser(String username, String password) throws SQLException {
        String sql = "select id,username,password,phone,email,created,updated from t_user where username = ? and password = ?;";
        ResultSet rs = this.findData(sql,username,password);
        User user = new User();
        if (rs.next()){
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setPhone(rs.getString("phone"));
            user.setCreated(rs.getTimestamp("created"));
            user.setUpdated(rs.getTimestamp("updated"));
        }
        JdbcUtil.close(rs);
        return user;
    }
    //--��ѯ--�ֻ����Ƿ�ռ��
    public boolean findByphone(String phone) throws SQLException {
        String sql = "select * from t_user where phone = ?;";
        ResultSet rs = this.findData(sql,phone);
        if (rs.next()){
            return true;
        }
        else{
            return false;
        }
    }
    //--��ѯ--�����Ƿ�ռ��
    public boolean findByemail(String email) throws SQLException {
        String sql = "select * from t_user where email = ?;";
        ResultSet rs = this.findData(sql,email);
        if (rs.next()){
            return true;
        }
        else{
            return false;
        }
    }
    //������������װת����User����
    public User mapper(ResultSet rs){
        User user = new User();
        try {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setPhone(rs.getString("phone"));
            user.setCreated(rs.getTimestamp("created"));
            user.setUpdated(rs.getTimestamp("updated"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
    //--��ѯ--���е��û���Ϣ
    public List findAll(){
        List list = new ArrayList();
        String sql = "select * from t_user";
        try {
            ResultSet rs = this.findData(sql);
            while(rs.next()){
                User user = mapper(rs);
                list.add(user);
            }
            JdbcUtil.close(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

}
