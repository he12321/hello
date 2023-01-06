package test;

import entity.Address;
import org.junit.jupiter.api.Test;
import save.AddressDao;

import java.sql.SQLException;
import java.util.List;

public class TestAddressDao {
    @Test//
    public void testsaveAddress(){
        Address add = new Address();
        add.setId(21);
        add.setReceiver_name("立方根");
        add.setReceiver_phone("001234");
        add.setReceiver_mobile("12345678912");
        add.setReceiver_state("江西省");
        add.setReceiver_city("吉安市");
        add.setReceiver_district("井冈山县");
        add.setReceiver_address("学府路888号");
        add.setReceiver_zip("343400");
        add.setStatus(1);//1--正常地址，2--删除
        add.setIs_default(1);//1--默认地址，0--不设默认
        AddressDao ad = new AddressDao();
        try {
            ad.saveAddress(add);
            System.out.println("添加用户_"+add.getReceiver_name()+"地址成功！");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Test//修改电话号码
    public void testupdateMobile(){
        int id = 4;//要修改的地址id
        String mobile = "13612345678";//要修改的电话号码
        AddressDao ad = new AddressDao();
        try {
            ad.updateMobile(id,mobile);
            System.out.println("改地址的手机号修改成功！");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test//修改固定电话
    public void testupdatePhone(){
        int id = 4;//要修改的地址id
        String phone = "0796888888";//要修改的电话号码
        AddressDao ad = new AddressDao();
        try {
            ad.updateMobile(id,phone);
            System.out.println("改地址的修改成功！");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test//修改收件人
    public void testupdateReciverName(){
        int id = 3;
        String newname = "java";
        AddressDao ad = new AddressDao();
        try {
            ad.updateReceivername(id,newname);
            System.out.println("id = "+id+"的收件人修改为"+newname+"成功！");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test//修改地址
    public void testUpdateaddress(){
        int id = 5;
        String state = "江西省";
        String city = "加纳市";
        String district = "加纳县";
        String detail = "学府路765号";
        AddressDao ad = new AddressDao();
        try {
            ad.updateAddress(id,state,city,district,detail);
            System.out.println("地址修改成功！");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test//查询所有用户名
    public void testfindAll(){
        AddressDao ad = new AddressDao();
        try {
            List<Address> list = ad.findAll();
            for (Address addr:list){
                System.out.println(addr);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
