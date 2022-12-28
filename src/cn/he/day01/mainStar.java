package cn.he.day01;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 * 窗体类：JFrame  ----了解
 * javaswing
 */
public class mainStar {
    //音乐播放器
    static AudioClip ac;
    static URL url;
    //加载静态资源
    static {
        url = mainStar.class.getResource("111.mav");//初始化音乐地址
        //初始化播放器
        ac = Applet.newAudioClip(url);
    }

    //初始化
    public static void main(String[] args) {
        //播放音乐
        ac.play();
        //创建一个窗口对象
        JFrame jf = new JFrame("满天星");
        //设置窗口的大小
        jf.setSize(1024, 700);
        //设置窗口的位置
        jf.setLocation(100, 100);
        //退出窗口的时候，关闭进程
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //将画布添加到窗体中
        starJpanel sj = new starJpanel();
        jf.add(sj);

        //窗体可见
        jf.setVisible(true);
    }
}
