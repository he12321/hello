package cn.he.day01;
import java.util.Scanner;
/*
    �ж��Ƿ�������
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        if(x==0||x==1){
            System.out.println(x+"��������");
            return;
        }
        for(int i=2;i<x;i++){
            if(x%i==0) {
                System.out.println(x + "��������");
                return;
            }
        }
        System.out.println(x+"������");
    }
}
