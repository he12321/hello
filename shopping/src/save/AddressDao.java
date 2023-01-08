package save;

import entity.Address;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDao extends AddressBase {
    //�����ַ
    public void saveAddress(Address addr) throws SQLException {
        String sql = "insert into t_shipping(user_id,receiver_name,receiver_phone,receiver_mobile," +
                "receiver_state, receiver_city,receiver_district,receiver_address, " +
                "receiver_zip,created,updated,status,is_default) values(?,?,?,?,?, ?,?,?,?,NOW(), NOW(),?,?); ";
        this.updateData(sql,addr.getId(),addr.getReceiver_name(),addr.getReceiver_phone(),addr.getReceiver_mobile(),
                addr.getReceiver_state(),addr.getReceiver_city(),addr.getReceiver_district(),addr.getReceiver_address(),
                addr.getReceiver_zip(), addr.getStatus(),addr.getIs_default());
    }
    //�޸ĵ�ַadd_id���ֻ���
    public void updateMobile(int id,String mobile) throws SQLException {//add_id
        String sql = "update t_shipping set receiver_mobile=? where add_id =?;";
        this.updateData(sql,mobile,id);
    }
    //�޸ĵ�ַadd_id�Ĺ̶��绰
    public void updatePhone(int id,String phone) throws SQLException {//add_id
        String sql = "update t_shipping set receiver_phone=? where add_id =?;";
        this.updateData(sql,phone,id);
    }
    //�޸��ռ���������
    public void updateReceivername(int id,String receiverName) throws SQLException {
        String sql = "update t_shipping set receiver_name=? where add_id=?;";
        this.updateData(sql,receiverName,id);
    }
    //�޸�������ַ       (---update�޸��˶���е�ֵ������֮���ö������Ӷ���Ҫ��and ---)
    public void updateAddress(int id,String state,String city,String district,String detail) throws SQLException {
        String sql = "update t_shipping set receiver_state=?,receiver_city=?, receiver_district=?, " +
                "receiver_address=? where add_id =?";
        this.updateData(sql,state,city,district,detail,id);
    }

    //--��ѯ--
    //�����������װ��Ϊ��ַ����
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
            //java.sql.SQLException: ���� 14 �е�ֵ (true) ִ�� getInt ʧ��
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return addr;
    }
    /*Mysql�У����ʹ��tinyint�������ֶε��������ͣ�ӳ�䵽Java���������У�
    ��������ʹ�������Boolean���������գ�Ҳ����ʹ��Java��int���������ա�
    ��MySQL�д洢��tinyint(1)�������ݣ��������Դ洢0��1������һ��һλ��Ȼ
    �������ԣ�0-9������������������tinyint(1)��ʹ��ʱ,0ӳ��ΪJava�е�Boolean
    ����false��1-9���ֶ���ӳ��Ϊtrue��
    */
    //--��ѯ--���е�ַ��Ϣ
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
