package cn.yang;

import sun.plugin.javascript.navig4.Layer;
/*
    ��װcell����
    һ��layer�����ɸ�cell���
 */
public class Cell {
    private boolean populated = false;//0-�޿��ơ�1-�п���
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
