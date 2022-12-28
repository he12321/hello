package cn.yang;

import java.util.Random;

/*
    卡牌的数据封装--工具类
    创建卡牌的数据
 */
public class CardTool {
    //数组储存卡牌名称
    public static String [] cardName = {"刷子","剪刀","叉子","奶瓶","干草","手套", "树桩",
            "棉花","毛线","水桶","火","玉米","白菜","草","萝卜","铃铛"};
    public static Random random = new Random();
    public static String GanerateRandomCardName(){
        int randomindex = random.nextInt(cardName.length);//随机产生卡牌名称
        return cardName[randomindex];
    }
    //封装一个方法实现：如何去创建出随机的卡牌数组
    public static Card[] GanerateCard(int size){
        Card []cards = new Card[size];
        //注意i++
        for (int i=0;i<size;i+=3){
           Card c1 = new Card(GanerateRandomCardName());
           Card c2 = new Card(GanerateRandomCardName());
           Card c3 = new Card(GanerateRandomCardName());
           cards[i] = c1;
           cards[i+1] = c2;
           cards[i+2] = c3;
        }
        //打乱顺序
        for (int i = 0; i < cards.length; i++) {
            Card cardA = cards[i];
            int index = random.nextInt(cards.length);
            Card cardB = cards[index];

            Card temp = cardA;
            cards[i] = cardB;
            cards[index] = temp;
        }
        return cards;
    }

}
