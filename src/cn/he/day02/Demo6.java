package cn.he.day02;

import java.util.Scanner;
/*
�ж�������ֻ����Ƿ��ʽ��ȷ
 */
public class Demo6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String shu =  input.next();
        String sjregex = "^\\d{11}$";
        boolean isright = shu.matches(sjregex);
        if(isright){
            System.out.println("�ֻ���������ȷ��");
        }
        else{
            System.out.println("��������");
        }
    }
}
