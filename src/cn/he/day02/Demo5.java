package cn.he.day02;

import java.util.Scanner;
/*
���֤��֤---�ж���������֤�Ƿ���ϸ�ʽ
 */
public class Demo5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("���������֤���룺");
        String string = input.next();
        //18λ���֤    ���һλ0-9��X
        String idregex = "^\\d{17}(\\d|X)$";
        boolean isright = string.matches(idregex);
        if(!isright){
            System.out.println("��������");
        }
        else{
            System.out.println("ע��ɹ���");
        }
    }
}
