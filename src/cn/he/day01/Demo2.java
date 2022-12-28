package cn.he.day01;

import java.util.Arrays;
/*
    向一个整型数组中添加元素
*/
public class Demo2 {
    public static void main(String[] args) {
        int []a={1,3,4,2};
        int []arr=new Demo2().add(a,6,6);
        System.out.print(Arrays.toString(arr));
    }
    public int[] add(int []src,int...x) {
        int []arr =new int[src.length+x.length];
        System.arraycopy(src,0,arr,0,src.length);
    /*
    src - 源数组。
    srcPos - 源数组中的起始位置。
    dest - 目标数组。
    destPos - 目标数据中的起始位置。
    length - 要复制的数组元素的数量。
    */
        System.arraycopy(x,0,arr,src.length,x.length);
        return arr;
    }

}