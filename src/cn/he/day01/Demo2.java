package cn.he.day01;

import java.util.Arrays;
/*
    ��һ���������������Ԫ��
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
    src - Դ���顣
    srcPos - Դ�����е���ʼλ�á�
    dest - Ŀ�����顣
    destPos - Ŀ�������е���ʼλ�á�
    length - Ҫ���Ƶ�����Ԫ�ص�������
    */
        System.arraycopy(x,0,arr,src.length,x.length);
        return arr;
    }

}