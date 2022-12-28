package cn.yang.TestYang;

import javax.swing.*;

public class TestWindow extends JFrame {
    //构造方法 初始化数据
    public TestWindow(){
        this.setTitle("羊了个羊");
        this.setSize(480,800);

        //设置布局----绝对布局
        this.getContentPane().setLayout(null);
        this.getContentPane().setBounds(0,0,400,800);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    //程序入口
    public static void main(String[] args) {
        new TestWindow();
    }

}
