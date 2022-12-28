package cn.yang;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Card extends Component{
    private String name;//卡牌名字
    private boolean isGrary;//表示当前卡牌
    private Image image;
    private Image grayImage;//灰色图片

    private Integer x;//x坐标
    private Integer y;//y坐标
    private Integer width;//宽
    private Integer height;//高

    public Card(String name){
        //构造方法初始化成员变量
        this.name = name;
        this.image = Toolkit.getDefaultToolkit().getImage("res/"+name+".png");
        this.grayImage = Toolkit.getDefaultToolkit().getImage("res/"+name+"_灰.png");
        this.width = 59;
        this.height = 66;
        this.x = 0;
        this.y = 0;
        //匿名内部类 鼠标点击事件的处理
        this.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                System.out.println("点了一下");
                Card card = (Card) e.getSource();
                card.getParent().remove(card);
                if(card.isGrary()){
                    //灰色
                    return;
                }
                else{
                    //删除全部的鼠标点击事件
                    MouseListener []mouseListeners = card.getMouseListeners();
                    for(MouseListener m:mouseListeners){
                        card.removeMouseListener(m);
                    }
                }
            }
        });
    }

    public void paint(Graphics g){//加载图片
        if(this.isGrary()){
            g.drawImage(this.grayImage,x,y,null);
        }
        else{
            g.drawImage(this.image,x,y,null);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGrary() {
        return isGrary;
    }

    public void setGrary(boolean grary) {
        isGrary = grary;
    }
}
