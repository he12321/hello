package cn.he.day02;

public class Demo3 {
    public static void main(String[] args) {
        String str = "abcdE";
        //����������λ��ĸ
        String regex = "^[a-xA-Z]{5,}$";
        System.out.println(str.matches(regex));
        //һ��ͨ��� * ? +
        //һ��1-9�����ֺ�һλa-z����ϣ���Ͽ��Գ����������
        str = "3d2a4da4e";
        regex = "^([1-9][a-z])*$";
        System.out.println(str.matches(regex));//true
        str = "1a2v";
        regex = "^[1-9][a-z]?$";
        System.out.println(str.matches(regex));//flase
        str = "2a2a";
        regex = "^[1-9][a-z]+$";
        System.out.println(str.matches(regex));//true
        /*
        X?X һ�λ�һ��Ҳû��
        X*X ��λ���
        X+X һ�λ���
         */
        //1.ƥ������
        //2.ƥ�����֤
    }
}
