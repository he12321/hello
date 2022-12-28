package cn.yang.TestYang;

import cn.yang.Card;
import cn.yang.CardTool;


import javax.swing.*;
import java.util.TimerTask;

public class TestShowCards extends JFrame {
    public TestShowCards(){
        Card []cards = CardTool.GanerateCard(60);
        this.setTitle("���˸���");
        this.setSize(480,800);

        //���ò���----���Բ���
        this.getContentPane().setLayout(null);
        this.getContentPane().setBounds(0,0,400,800);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        //����λ��
        /*Card c1= new Card("ˢ��");
        Card c2= new Card("��");
        c1.setLocation(10,10);
        c1.setSize(59,66);
        this.getContentPane().add(c1);
        c2.setLocation(59,66);
        c2.setSize(59,66);
        this.getContentPane().add(c2);*/

        int x =30, y = 10;
        for(int i=0;i<cards.length;i++){
            cards[i].setLocation(x,y);
            cards[i].setSize(59,66);
            this.getContentPane().add(cards[i]);
            x+=59;
            if(x>=400){
                x=30;
                y+=56;
            }
        }

        //��ʱ������ʱˢ��һ��ҳ��
        new java.util.Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                repaint();//�ػ�
            }
        },10,10);
        //���ӣ������������ô���   TimeTask�����ô���  delay��40 ���ʱ��10����
    }
    public static void main(String[] args) {
        new TestShowCards();
    }
}
