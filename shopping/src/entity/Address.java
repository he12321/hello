package entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Address implements Serializable {
    private int id;//�û�id
    private String receiver_name;//�ջ���
    private String receiver_phone;//�̶��绰
    private String receiver_mobile;//�ƶ��绰
    private String receiver_state;//ʡ
    private String receiver_city;//��
    private String receiver_district;//������
    private String receiver_address;//�ջ���ַ���磺xx·xx��
    private String receiver_zip;//��������
    private Timestamp created;//����ʱ�� timestamp
    private Timestamp updated;//����ʱ�� timestamp
    private int status;//��ַ״̬��1-������2-ɾ��
    private int is_default;//�Ƿ�ΪĬ�ϵ�ַ��1-true,0-false
    //�����޲�
    public Address(){

    }

    public Address(String receiver_name, String receiver_phone, String receiver_mobile, String receiver_state, String receiver_city, String receiver_district, String receiver_address, String receiver_zip) {
        this.receiver_name = receiver_name;
        this.receiver_phone = receiver_phone;
        this.receiver_mobile = receiver_mobile;
        this.receiver_state = receiver_state;
        this.receiver_city = receiver_city;
        this.receiver_district = receiver_district;
        this.receiver_address = receiver_address;
        this.receiver_zip = receiver_zip;
    }

    public String getReceiver_zip() {
        return receiver_zip;
    }

    public void setReceiver_zip(String receiver_zip) {
        this.receiver_zip = receiver_zip;
    }

    public Address(int id, String receiver_name, String receiver_phone, String receiver_mobile, String receiver_state, String receiver_city, String receiver_district, String receiver_address, String receiver_zip, Timestamp created, Timestamp updated, int status, int is_default) {
        this.id = id;
        this.receiver_name = receiver_name;
        this.receiver_phone = receiver_phone;
        this.receiver_mobile = receiver_mobile;
        this.receiver_state = receiver_state;
        this.receiver_city = receiver_city;
        this.receiver_district = receiver_district;
        this.receiver_address = receiver_address;
        this.receiver_zip = receiver_zip;
        this.created = created;
        this.updated = updated;
        this.status = status;
        this.is_default = is_default;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getReceiver_phone() {
        return receiver_phone;
    }

    public void setReceiver_phone(String receiver_phone) {
        this.receiver_phone = receiver_phone;
    }

    public String getReceiver_mobile() {
        return receiver_mobile;
    }

    public void setReceiver_mobile(String receiver_mobile) {
        this.receiver_mobile = receiver_mobile;
    }

    public String getReceiver_state() {
        return receiver_state;
    }

    public void setReceiver_state(String receiver_state) {
        this.receiver_state = receiver_state;
    }

    public String getReceiver_city() {
        return receiver_city;
    }

    public void setReceiver_city(String receiver_city) {
        this.receiver_city = receiver_city;
    }

    public String getReceiver_district() {
        return receiver_district;
    }

    public void setReceiver_district(String receiver_district) {
        this.receiver_district = receiver_district;
    }

    public String getReceiver_address() {
        return receiver_address;
    }

    public void setReceiver_address(String receiver_address) {
        this.receiver_address = receiver_address;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIs_default() {
        return is_default;
    }

    public void setIs_default(int is_default) {
        this.is_default = is_default;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", receiver_name='" + receiver_name + '\'' +
                ", receiver_phone='" + receiver_phone + '\'' +
                ", receiver_mobile='" + receiver_mobile + '\'' +
                ", receiver_state='" + receiver_state + '\'' +
                ", receiver_city='" + receiver_city + '\'' +
                ", receiver_district='" + receiver_district + '\'' +
                ", receiver_address='" + receiver_address + '\'' +
                ", receiver_zip='" + receiver_zip + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", status=" + status +
                ", is_default=" + is_default +
                '}';
    }
}
