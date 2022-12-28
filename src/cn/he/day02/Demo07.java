package cn.he.day02;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
日期类
 */
public class Demo07 {
    public static void main(String[] args) throws ParseException {
        Date  date = new Date();
        System.out.println(date);
        //字符串转换为java.util.Date的时间
        String datestr = "2022-12-27";
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date date1= sd.parse(datestr);
        System.out.println(date1);

        //将日期格式转换为特定的时间
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datestr2 = sf.format(date);
        System.out.println(datestr2);
    }
}
