package cn.he.day02;

import java.util.Scanner;

public class Demo4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("���������䣺");
        String email = input.next();
        //xxxxxxxx@xxxx.xxx
        String emailregex = "^\\w+@\\w+\\.+\\w+$";//\w �����ַ���[a-zA-Z_0-9]
        boolean issatisfy = email.matches(emailregex);
        if(issatisfy){
            System.out.println("ע��ɹ���");
        }
        else{
            System.out.println("��������");
        }

    }
}
