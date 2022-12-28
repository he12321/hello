package cn.he.day01;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * JPanel：画布----相片
 * 1、画背景
 */
public class starJpanel extends JPanel implements Runnable{
    static BufferedImage bg = null;//保存背景图片的
    //存储所有的x坐标
    int []x = new int[300];
    //存储所有的y坐标
    int []y = new int[300];
    //定义月亮得偏移
    int x1=195;
    //构造方法
    public starJpanel(){
        Random rand = new Random();
        for (int i=0;i<x.length;i++){
            x[i] = rand.nextInt(1024);
            y[i] = rand.nextInt(700);
        }
        new Thread(this).start();
    }
    //静态资源的文件加载
    static {
        try {
            bg = ImageIO.read(starJpanel.class.getResource("bg.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //重写paint
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //画背景
        setBackground(Color.black);
        //g.drawImage(bg,0,0,1024,700,null);
        //画一个月亮
        g.setColor(Color.yellow);
        g.fillOval(100,100,100,100);
        g.setColor(Color.black);
        g.fillOval(x1,100,100,100);
        //画一个星星
        g.setColor(Color.yellow);
        g.drawString("*",300,260);
        //画300个星星
        for (int i=0;i<x.length;i++){
            g.setColor(Color.yellow);
            g.drawString("*",x[i],y[i]);
        }
    }
    @Override
    public void run() {
        //TODO....  实现下落效果  坐标的变化
        while (true){
            //月亮坐标的变化
            x1-=1;
            if(x1==100){
                x1=200;
            }

            //TODO.....  遍历for循环  每一个坐标，下移的效果。
            for(int i=0;i<x.length;i++) {
                y[i]++;
                if (y[i] >= 700) {
                    y[i] = 0;
                }
            }
            //重绘，重复的调用paint方法
            repaint();
            //线程的休眠 sleep()
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}