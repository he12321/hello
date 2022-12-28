package cn.he.day02;

public class Demo3 {
    public static void main(String[] args) {
        String str = "abcdE";
        //最少是无五位字母
        String regex = "^[a-xA-Z]{5,}$";
        System.out.println(str.matches(regex));
        //一组通配符 * ? +
        //一组1-9的数字和一位a-z的组合，组合可以出现任意次数
        str = "3d2a4da4e";
        regex = "^([1-9][a-z])*$";
        System.out.println(str.matches(regex));//true
        str = "1a2v";
        regex = "^[1-9][a-z]?$";
        System.out.println(str.matches(regex));//flase
        str = "2a2a";
        regex = "^[1-9][a-z]+$";
        System.out.println(str.matches(regex));//true
        /*
        X?X 一次或一次也没有
        X*X 零次或多次
        X+X 一次或多次
         */
        //1.匹配邮箱
        //2.匹配身份证
    }
}
