package cn.he.day02;

import java.util.Scanner;
/*
身份证验证---判断输入的身份证是否符合格式
 */
public class Demo5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入身份证号码：");
        String string = input.next();
        //18位身份证    最后一位0-9或X
        String idregex = "^\\d{17}(\\d|X)$";
        boolean isright = string.matches(idregex);
        if(!isright){
            System.out.println("输入有误！");
        }
        else{
            System.out.println("注册成功！");
        }
    }
}
