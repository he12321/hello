package cn.yang;

import sun.plugin.javascript.navig4.Layer;
/*
    封装cell类型
    一个layer由若干个cell组成
 */
public class Cell {
    private boolean populated = false;//0-无卡牌、1-有卡牌
    private Card card;
    private Layer layer;

    public boolean isPopulated() {
        return populated;
    }

    public void setPopulated(boolean populated) {
        this.populated = populated;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Layer getLayer() {
        return layer;
    }

    public void setLayer(Layer layer) {
        this.layer = layer;
    }
}
