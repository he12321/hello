package cn.yang.TestYang;

import javax.swing.*;

public class TestWindow extends JFrame {
    //���췽�� ��ʼ������
    public TestWindow(){
        this.setTitle("���˸���");
        this.setSize(480,800);

        //���ò���----���Բ���
        this.getContentPane().setLayout(null);
        this.getContentPane().setBounds(0,0,400,800);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    //�������
    public static void main(String[] args) {
        new TestWindow();
    }

}
