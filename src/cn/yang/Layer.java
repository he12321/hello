package cn.yang;

public class Layer {
    private int xoffset;//x的位移量
    private int yoffset;//y的位移量

    private int row;//行
    private int col;//列

    private int capacity;//容量：当前图层最大容纳的数量
    private int size;//当前图层能放多少张卡牌

    private Layer layer;//图层的上一层对象
    private Cell[][] cells = null;//随机生成的

    //初始化
    public Layer(int row, int col) throws Exception {
        this.row = row;
        this.col = col;
        this.xoffset = 0;
        this.yoffset = 0;
        this.size = 0;
        this.cells = new Cell[this.row][this.col];//行、列
        this.capacity = this.row * this.col;
        if(this.capacity % 3 != 0){
            throw new Exception("容量不是3的倍数！");
        }
    }

    //展示cell
    public void showCell(){
        for(int row=0;row<cells.length;row++){
            for (int cel=0;col<cells[row].length;cel++){
                Card card = cells[row][cel].getCard();
                if (card==null){
                    System.out.println("--card为空--");
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
