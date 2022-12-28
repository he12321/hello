package cn.he.day01;
import java.util.Scanner;
/*
    判断是否是素数
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        if(x==0||x==1){
            System.out.println(x+"不是素数");
            return;
        }
        for(int i=2;i<x;i++){
            if(x%i==0) {
                System.out.println(x + "不是素数");
                return;
            }
        }
        System.out.println(x+"是素数");
    }
}
