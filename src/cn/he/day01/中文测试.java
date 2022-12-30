package cn.he.day01;
import java.util.Scanner;

public class 中文测试 {
    public static void main(String[] args) {
        String str = "";
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一句中文：");
        str = input.next();
        System.out.print(str);
    }
}
