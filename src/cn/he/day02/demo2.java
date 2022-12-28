package cn.he.day02;

public class demo2 {
    public static void main(String[] args) {
        //String regex = "[1234567890]";
        //正则表达式^   $s结尾
        String regex = "[0~9]{4}";
        System.out.println();

        //6-9位之间的数字
        String str2 = "12345678";
        String regex1 = "[0-9]{6-9}";
        System.out.println(str2.matches(regex1));

        //转义字符 \d,转义为数字0-9
        regex1 = "\\d{6,9}";
        System.out.println(str2.matches(regex1));

        //以^开头$结尾的
        regex1 = "^\\d[]{6,9}$";




    }
}
