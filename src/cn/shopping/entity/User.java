package cn.shopping.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/*
    根据数据库设计类

 */
public class User implements Serializable {
    private int id;
    private String username;//用户名
    private String password;//密码，加密处理
    private String phone;//注册手机号
    private String email;//注册邮箱
    private Timestamp created;//创建时间 timestamp
    private Timestamp updated;//更新时间 timestamp

    public User(){

    }

    public User(int id, String username, String password, String phone, String email, Timestamp created, Timestamp updated) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.created = created;
        this.updated = updated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdate() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(phone, user.phone) && Objects.equals(email, user.email) && Objects.equals(created, user.created) && Objects.equals(updated, user.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, phone, email, created, updated);
    }

    @Override
    public String toString() {
        return "User{" +
                "id:" + id +
                ", username:'" + username + '\'' +
                ", password:'" + password + '\'' +
                ", phone:'" + phone + '\'' +
                ", email:'" + email + '\'' +
                ", created:" + created +
                ", update:" + updated +
                '}';
    }
}
