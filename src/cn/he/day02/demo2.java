package cn.he.day02;

public class demo2 {
    public static void main(String[] args) {
        //String regex = "[1234567890]";
        //������ʽ^   $s��β
        String regex = "[0~9]{4}";
        System.out.println();

        //6-9λ֮�������
        String str2 = "12345678";
        String regex1 = "[0-9]{6-9}";
        System.out.println(str2.matches(regex1));

        //ת���ַ� \d,ת��Ϊ����0-9
        regex1 = "\\d{6,9}";
        System.out.println(str2.matches(regex1));

        //��^��ͷ$��β��
        regex1 = "^\\d[]{6,9}$";




    }
}
