package cn.he.day01;
import java.util.Scanner;

public class ���Ĳ��� {
    public static void main(String[] args) {
        String str = "";
        Scanner input = new Scanner(System.in);
        System.out.print("������һ�����ģ�");
        str = input.next();
        System.out.print(str);
    }
    /*
        ���߳�
         */
    public static class Demo3 extends Thread {
        public static void main(String[] args) {
            Demo3 demo3 = new Demo3();
            demo3.start();
        }
        public void run(){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
