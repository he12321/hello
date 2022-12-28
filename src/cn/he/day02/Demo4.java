package cn.he.day02;

import java.util.Scanner;

public class Demo4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入邮箱：");
        String email = input.next();
        //xxxxxxxx@xxxx.xxx
        String emailregex = "^\\w+@\\w+\\.+\\w+$";//\w 单词字符：[a-zA-Z_0-9]
        boolean issatisfy = email.matches(emailregex);
        if(issatisfy){
            System.out.println("注册成功！");
        }
        else{
            System.out.println("输入有误！");
        }

    }
}
