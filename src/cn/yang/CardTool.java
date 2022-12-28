package cn.yang;

import java.util.Random;

/*
    ���Ƶ����ݷ�װ--������
    �������Ƶ�����
 */
public class CardTool {
    //���鴢�濨������
    public static String [] cardName = {"ˢ��","����","����","��ƿ","�ɲ�","����", "��׮",
            "�޻�","ë��","ˮͰ","��","����","�ײ�","��","�ܲ�","����"};
    public static Random random = new Random();
    public static String GanerateRandomCardName(){
        int randomindex = random.nextInt(cardName.length);//���������������
        return cardName[randomindex];
    }
    //��װһ������ʵ�֣����ȥ����������Ŀ�������
    public static Card[] GanerateCard(int size){
        Card []cards = new Card[size];
        //ע��i++
        for (int i=0;i<size;i+=3){
           Card c1 = new Card(GanerateRandomCardName());
           Card c2 = new Card(GanerateRandomCardName());
           Card c3 = new Card(GanerateRandomCardName());
           cards[i] = c1;
           cards[i+1] = c2;
           cards[i+2] = c3;
        }
        //����˳��
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
