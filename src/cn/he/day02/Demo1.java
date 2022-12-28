package cn.he.day02;

public class Demo1 {
    public Demo1(){
        System.out.println("这是构造方法。");
    }
    public static void test(){
        System.out.println("这是static静态方法");
    }
    public void mytest(){
        System.out.println("这是自定义方法");
    }
    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        demo1.mytest();
        test();
    }
}
