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
        add.setReceiver_name("������");
        add.setReceiver_phone("001234");
        add.setReceiver_mobile("12345678912");
        add.setReceiver_state("����ʡ");
        add.setReceiver_city("������");
        add.setReceiver_district("����ɽ��");
        add.setReceiver_address("ѧ��·888��");
        add.setReceiver_zip("343400");
        add.setStatus(1);//1--������ַ��2--ɾ��
        add.setIs_default(1);//1--Ĭ�ϵ�ַ��0--����Ĭ��
        AddressDao ad = new AddressDao();
        try {
            ad.saveAddress(add);
            System.out.println("����û�_"+add.getReceiver_name()+"��ַ�ɹ���");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Test//�޸ĵ绰����
    public void testupdateMobile(){
        int id = 4;//Ҫ�޸ĵĵ�ַid
        String mobile = "13612345678";//Ҫ�޸ĵĵ绰����
        AddressDao ad = new AddressDao();
        try {
            ad.updateMobile(id,mobile);
            System.out.println("�ĵ�ַ���ֻ����޸ĳɹ���");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test//�޸Ĺ̶��绰
    public void testupdatePhone(){
        int id = 4;//Ҫ�޸ĵĵ�ַid
        String phone = "0796888888";//Ҫ�޸ĵĵ绰����
        AddressDao ad = new AddressDao();
        try {
            ad.updateMobile(id,phone);
            System.out.println("�ĵ�ַ���޸ĳɹ���");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test//�޸��ռ���
    public void testupdateReciverName(){
        int id = 3;
        String newname = "java";
        AddressDao ad = new AddressDao();
        try {
            ad.updateReceivername(id,newname);
            System.out.println("id = "+id+"���ռ����޸�Ϊ"+newname+"�ɹ���");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test//�޸ĵ�ַ
    public void testUpdateaddress(){
        int id = 5;
        String state = "����ʡ";
        String city = "������";
        String district = "������";
        String detail = "ѧ��·765��";
        AddressDao ad = new AddressDao();
        try {
            ad.updateAddress(id,state,city,district,detail);
            System.out.println("��ַ�޸ĳɹ���");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test//��ѯ�����û���
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
