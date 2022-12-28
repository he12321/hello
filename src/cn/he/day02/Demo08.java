package cn.he.day02;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    java.sql.Date��java.util.Date������
    JDBC�����ݿ�Ĳ�������ʹ��java.sql.Date����
 */
public class Demo08 {
    public static void main(String[] args) throws ParseException {
        //���û���������������ڵ�������ӵ����ݿ�����
        String datestr = "2022-12��27��";
        //���û���������������ڵ���ʽ
        SimpleDateFormat smdate =  new SimpleDateFormat("yyyy-MM��dd��");
        Date date1 = smdate.parse(datestr);
        System.out.println(date1);//Tue Dec 27 00:00:00 CST 2022
        //��util.Dateת��Ϊsql.Date
        java.sql.Date sqldate = new java.sql.Date(date1.getTime());
        System.out.println(sqldate);//2022-12-27
        //�����ݿ��е��������͵����ݣ�ʹ�������ʽ��ʾ��ҳ����
        Date date = sqldate;
        SimpleDateFormat smform = new SimpleDateFormat("yyyy��MM��dd��");
        String datestr2 = smform.format(date);
        System.out.println(datestr2);//2022��12��27��
        //��ȡϵͳ������
        System.currentTimeMillis();
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        System.out.println(ts);//2022-12-27 16:43:29.286
        long mm = date.getTime();
        System.out.println(mm);//1672070400000


    }
}
