package cn.he.day01;

public class Demo4 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
       Demo4 demo4 = new Demo4();
       //ִ�е�ʱ��ʱ�����
       for(int i = 0;i < 10;i++){
           //start������֪ͨ����ϵͳ����������ʲôʱ��ִ�����ɲ���ϵͳ������
           new Thread(demo4).start();
       }
    }
}
