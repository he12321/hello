package cn.yang;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Card extends Component{
    private String name;//��������
    private boolean isGrary;//��ʾ��ǰ����
    private Image image;
    private Image grayImage;//��ɫͼƬ

    private Integer x;//x����
    private Integer y;//y����
    private Integer width;//��
    private Integer height;//��

    public Card(String name){
        //���췽����ʼ����Ա����
        this.name = name;
        this.image = Toolkit.getDefaultToolkit().getImage("res/"+name+".png");
        this.grayImage = Toolkit.getDefaultToolkit().getImage("res/"+name+"_��.png");
        this.width = 59;
        this.height = 66;
        this.x = 0;
        this.y = 0;
        //�����ڲ��� ������¼��Ĵ���
        this.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                System.out.println("����һ��");
                Card card = (Card) e.getSource();
                card.getParent().remove(card);
                if(card.isGrary()){
                    //��ɫ
                    return;
                }
                else{
                    //ɾ��ȫ����������¼�
                    MouseListener []mouseListeners = card.getMouseListeners();
                    for(MouseListener m:mouseListeners){
                        card.removeMouseListener(m);
                    }
                }
            }
        });
    }

    public void paint(Graphics g){//����ͼƬ
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
