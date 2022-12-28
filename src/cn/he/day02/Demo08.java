package cn.he.day02;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    java.sql.Date是java.util.Date的子类
    JDBC与数据库的操作可以使用java.sql.Date类型
 */
public class Demo08 {
    public static void main(String[] args) throws ParseException {
        //将用户输入的数据以日期的类型添加到数据库里面
        String datestr = "2022-12月27日";
        //将用户输入的数据以日期的形式
        SimpleDateFormat smdate =  new SimpleDateFormat("yyyy-MM月dd日");
        Date date1 = smdate.parse(datestr);
        System.out.println(date1);//Tue Dec 27 00:00:00 CST 2022
        //将util.Date转换为sql.Date
        java.sql.Date sqldate = new java.sql.Date(date1.getTime());
        System.out.println(sqldate);//2022-12-27
        //将数据库中的日期类型的数据，使用特殊格式显示到页面中
        Date date = sqldate;
        SimpleDateFormat smform = new SimpleDateFormat("yyyy年MM月dd日");
        String datestr2 = smform.format(date);
        System.out.println(datestr2);//2022年12月27日
        //获取系统毫秒数
        System.currentTimeMillis();
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        System.out.println(ts);//2022-12-27 16:43:29.286
        long mm = date.getTime();
        System.out.println(mm);//1672070400000


    }
}
