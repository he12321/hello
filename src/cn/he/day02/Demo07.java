package cn.he.day02;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
������
 */
public class Demo07 {
    public static void main(String[] args) throws ParseException {
        Date  date = new Date();
        System.out.println(date);
        //�ַ���ת��Ϊjava.util.Date��ʱ��
        String datestr = "2022-12-27";
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date date1= sd.parse(datestr);
        System.out.println(date1);

        //�����ڸ�ʽת��Ϊ�ض���ʱ��
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datestr2 = sf.format(date);
        System.out.println(datestr2);
    }
}
