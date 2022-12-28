package cn.he.day02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
    需求1：计算从你出生到现在活了多少天？
 */
public class Demo09 {
    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        System.out.println("情输入你的出生年月日（xxxx-xx-xx）");
        String birthday = input.next();
        //将字符串转化为时间
        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
        Date date =smf.parse(birthday);
        Date now = new Date();
        //计算我从出生到现在活的时间
        long ms = now.getTime()-date.getTime();//活了多久(ms)
        long days = ms/(1000*60*60*24);
        System.out.print("活久见，我竟然活了"+days+"天");

    }
}
