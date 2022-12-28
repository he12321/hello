package cn.he.day01;

public class Demo4 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
       Demo4 demo4 = new Demo4();
       //执行的时候时无序的
       for(int i = 0;i < 10;i++){
           //start方法是通知操作系统就绪，具体什么时候执行是由操作系统决定的
           new Thread(demo4).start();
       }
    }
}
