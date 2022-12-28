package cn.yang;

public class Layer {
    private int xoffset;//x��λ����
    private int yoffset;//y��λ����

    private int row;//��
    private int col;//��

    private int capacity;//��������ǰͼ��������ɵ�����
    private int size;//��ǰͼ���ܷŶ����ſ���

    private Layer layer;//ͼ�����һ�����
    private Cell[][] cells = null;//������ɵ�

    //��ʼ��
    public Layer(int row, int col) throws Exception {
        this.row = row;
        this.col = col;
        this.xoffset = 0;
        this.yoffset = 0;
        this.size = 0;
        this.cells = new Cell[this.row][this.col];//�С���
        this.capacity = this.row * this.col;
        if(this.capacity % 3 != 0){
            throw new Exception("��������3�ı�����");
        }
    }

    //չʾcell
    public void showCell(){
        for(int row=0;row<cells.length;row++){
            for (int cel=0;col<cells[row].length;cel++){
                Card card = cells[row][cel].getCard();
                if (card==null){
                    System.out.println("--cardΪ��--");
                }
                else{
                    System.out.println(card.getName());
                }
            }
        }
    }

    public int getCellnum(){
        int cellnum = 0;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[row].length; j++) {
                cellnum++;
            }
        }
        return cellnum;
    }

}
