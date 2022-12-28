package cn.he.day02;

import java.util.Scanner;
/*
判断输入的手机号是否格式正确
 */
public class Demo6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String shu =  input.next();
        String sjregex = "^\\d{11}$";
        boolean isright = shu.matches(sjregex);
        if(isright){
            System.out.println("手机号输入正确！");
        }
        else{
            System.out.println("输入有误！");
        }
    }
}
