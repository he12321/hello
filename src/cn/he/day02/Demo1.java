package cn.he.day02;

public class Demo1 {
    public Demo1(){
        System.out.println("���ǹ��췽����");
    }
    public static void test(){
        System.out.println("����static��̬����");
    }
    public void mytest(){
        System.out.println("�����Զ��巽��");
    }
    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        demo1.mytest();
        test();
    }
}
