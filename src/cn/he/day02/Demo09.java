package cn.he.day02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
    ����1�����������������ڻ��˶����죿
 */
public class Demo09 {
    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        System.out.println("��������ĳ��������գ�xxxx-xx-xx��");
        String birthday = input.next();
        //���ַ���ת��Ϊʱ��
        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
        Date date =smf.parse(birthday);
        Date now = new Date();
        //�����Ҵӳ��������ڻ��ʱ��
        long ms = now.getTime()-date.getTime();//���˶��(ms)
        long days = ms/(1000*60*60*24);
        System.out.print("��ü����Ҿ�Ȼ����"+days+"��");

    }
}
