public class Lightsout{
    static int row;
    static int column;
    static Board board;
    
    public static void main(String[] args){
        while(true){
            System.out.print("row:");
            row = new java.util.Scanner(System.in).nextInt();
            if(row < 1 || row > 9){
                System.out.println("put 1 to 9");
            }else{
                break;
            }
        }
        while(true){
            System.out.print("column:");
            column = new java.util.Scanner(System.in).nextInt();
            if(column < 1 || column > 9){
                System.out.println("put 1 to 9");
            }else{
                break;
            }
        }
        board = new Board(row,column);
        board.print();
        while(true){
            board.onemove();
            board.print();
            if(board.checkfin())break;
        }
        System.out.println("Fin");
    }

}