package cn.he.day02;

import java.util.ArrayList;
import java.util.Iterator;

/*
    ArrayList���ϵ��÷�
 */
public class demo10 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        //�����Ԫ��
        list.add("hello");
        list.add("world");
        list.add("���");
        list.add("����");
        System.out.println(list);
        //ɾ��Ԫ��
        list.remove("!");
        System.out.println(list);
        //�޸�Ԫ��
        list.set(3,"����!");
        show(list);

        //forѭ������
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i));
        }
        //��ǿ��forѭ����foreach��
        show(list);
        //����������
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String str = it.next();
            System.out.print(str);
        }

    }
    public static void show(ArrayList<String> l){
        for(String str:l){
            System.out.print(str);
        }
        System.out.println();
    }
}
