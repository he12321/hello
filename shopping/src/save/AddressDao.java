package save;

import entity.Address;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDao extends AddressBase {
    //保存地址
    public void saveAddress(Address addr) throws SQLException {
        String sql = "insert into t_shipping(user_id,receiver_name,receiver_phone,receiver_mobile," +
                "receiver_state, receiver_city,receiver_district,receiver_address, " +
                "receiver_zip,created,updated,status,is_default) values(?,?,?,?,?, ?,?,?,?,NOW(), NOW(),?,?); ";
        this.updateData(sql,addr.getId(),addr.getReceiver_name(),addr.getReceiver_phone(),addr.getReceiver_mobile(),
                addr.getReceiver_state(),addr.getReceiver_city(),addr.getReceiver_district(),addr.getReceiver_address(),
                addr.getReceiver_zip(), addr.getStatus(),addr.getIs_default());
    }
    //修改地址add_id的手机号
    public void updateMobile(int id,String mobile) throws SQLException {//add_id
        String sql = "update t_shipping set receiver_mobile=? where add_id =?;";
        this.updateData(sql,mobile,id);
    }
    //修改地址add_id的固定电话
    public void updatePhone(int id,String phone) throws SQLException {//add_id
        String sql = "update t_shipping set receiver_phone=? where add_id =?;";
        this.updateData(sql,phone,id);
    }
    //修改收件人姓名：
    public void updateReceivername(int id,String receiverName) throws SQLException {
        String sql = "update t_shipping set receiver_name=? where add_id=?;";
        this.updateData(sql,receiverName,id);
    }
    //修改整个地址       (---update修改了多个列的值而各列之间用逗号连接而不要用and ---)
    public void updateAddress(int id,String state,String city,String district,String detail) throws SQLException {
        String sql = "update t_shipping set receiver_state=?,receiver_city=?, receiver_district=?, " +
                "receiver_address=? where add_id =?";
        this.updateData(sql,state,city,district,detail,id);
    }

    //--查询--
    //将结果集对象装换为地址对象
    public Address convertAddr(ResultSet rs) {
        Address addr = new Address();
        try {
            addr.setId(rs.getInt("user_id"));
            addr.setReceiver_name(rs.getString("receiver_name"));
            addr.setReceiver_phone(rs.getString("receiver_phone"));
            addr.setReceiver_mobile(rs.getString("receiver_mobile"));
            addr.setReceiver_state(rs.getString("receiver_state"));
            addr.setReceiver_city(rs.getString("receiver_city"));
            addr.setReceiver_district(rs.getString("receiver_district"));
            addr.setReceiver_address(rs.getString("receiver_address"));
            addr.setReceiver_zip(rs.getString("receiver_zip"));
            addr.setCreated(rs.getTimestamp("created"));
            addr.setUpdated(rs.getTimestamp("updated"));
            addr.setStatus(rs.getInt("status"));
            //addr.setIs_default(rs.getInt("is_default"));
            addr.setIs_default((rs.getBoolean("is_default")?1:0));
            //java.sql.SQLException: 对列 14 中的值 (true) 执行 getInt 失败
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return addr;
    }
    /*Mysql中，如果使用tinyint来设置字段的数据类型，映射到Java数据类型中，
    不仅可以使用上面的Boolean类型来接收，也可以使用Java中int类型来接收。
    在MySQL中存储的tinyint(1)类型数据，不仅可以存储0和1，任意一个一位自然
    数都可以（0-9）。不过，当这样（tinyint(1)）使用时,0映射为Java中的Boolean
    类型false，1-9数字都将映射为true。
    */
    //--查询--所有地址信息
    public List findAll() throws SQLException {
        List<Address> list = new ArrayList();
        String sql = "select user_id,receiver_name,receiver_phone,receiver_mobile," +
                "receiver_state, receiver_city,receiver_district,receiver_address," +
                " receiver_zip,created,updated,status,is_default from t_shipping";
        ResultSet rs = this.findData(sql);
        while(rs.next()){
            Address addr = convertAddr(rs);
            list.add(addr);
        }
        return list;
    }

}
