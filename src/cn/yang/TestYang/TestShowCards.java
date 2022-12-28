package cn.yang.TestYang;

import cn.yang.Card;
import cn.yang.CardTool;


import javax.swing.*;
import java.util.TimerTask;

public class TestShowCards extends JFrame {
    public TestShowCards(){
        Card []cards = CardTool.GanerateCard(60);
        this.setTitle("羊了个羊");
        this.setSize(480,800);

        //设置布局----绝对布局
        this.getContentPane().setLayout(null);
        this.getContentPane().setBounds(0,0,400,800);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        //设置位置
        /*Card c1= new Card("刷子");
        Card c2= new Card("火");
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

        //定时器，定时刷新一下页面
        new java.util.Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                repaint();//重绘
            }
        },10,10);
        //闹钟：明天起来起敲代码   TimeTask任务：敲代码  delay：40 间隔时间10分钟
    }
    public static void main(String[] args) {
        new TestShowCards();
    }
}
