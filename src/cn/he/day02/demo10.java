package cn.he.day02;

import java.util.ArrayList;
import java.util.Iterator;

/*
    ArrayList集合的用法
 */
public class demo10 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        //添加与元素
        list.add("hello");
        list.add("world");
        list.add("你好");
        list.add("世界");
        System.out.println(list);
        //删除元素
        list.remove("!");
        System.out.println(list);
        //修改元素
        list.set(3,"世界!");
        show(list);

        //for循环迭代
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i));
        }
        //增强型for循环（foreach）
        show(list);
        //迭代器迭代
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
