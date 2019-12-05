public class Board{
    private Light[][] quest;
    private boolean[][] answer;
    private int row;
    private int column;

    Board(int row,int column){
        boolean complete;
        this.row = row;
        this.column = column;
        quest = new Light[row][column];
        answer = new boolean[row][column];
        initializeQuest();
        while(complete = makequest()){
            if(complete == true)break;
        }
    }

    public boolean makequest(){
        int pushrate = new java.util.Random().nextInt(row*column-6);
        pushrate += 3;
        for(int r=0;r<row;r++){
            for(int c=0;c<column;c++){
                int pushjudge = new java.util.Random().nextInt(row*column);
                if(pushjudge <= pushrate){
                    answer[r][c] = true;
                    push(r,c);
                }else{
                    answer[r][c] = false;
                }
            }
        }
        if(checkfin())return false;
        else return true;
    }

    public void push(int r,int c){
        quest[r][c].change();
        if(r != 0)quest[r-1][c].change();
        if(r != row-1)quest[r+1][c].change();
        if(c != 0)quest[r][c-1].change();
        if(c != column-1)quest[r][c+1].change();
    }

    public void initializeQuest(){
        for(int r=0;r<row;r++){
            for(int c=0;c<column;c++){
                quest[r][c] = new Light();
            }
        }
    }
    public boolean checkfin(){
        boolean isFin = true;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(!(quest[i][j].getisOn()))isFin = false;
            }
        }
        return isFin;
    }

    public void print(){
        System.out.print("  ");
        for(int i=1;i<=column;i++){
            System.out.print(i);
        }
        System.out.print("\n\n");
        for(int j=1;j<=row;j++){
            System.out.print(j + " ");
            for(int n=0;n<column;n++){
                quest[j-1][n].printstate();
            }
            System.out.print("\n");
        }
    }

    public void onemove(){
        int r, c;
        while(true){
            System.out.print("row:");
            r = new java.util.Scanner(System.in).nextInt();
            if(r == -1){
                printans();
                return;
            }
            if(r < 1 || r > row){
                System.out.println("unexcepted input");
            }else{
                break;
            }
        }
        while(true){
            System.out.print("column:");
            c = new java.util.Scanner(System.in).nextInt();
            if(c < 1 || c > column){
                System.out.println("unexcepted input");
            }else{
                break;
            }
        }
        push(r-1,c-1);
        if(answer[r-1][c-1] == true) answer[r-1][c-1] = false;
        else answer[r-1][c-1] = true;
    }

    public void printans(){
        System.out.println("\n----------answer----------");
        for(int r=0;r<row;r++){
            for(int c=0;c<column;c++){
                if(answer[r][c])System.out.println("push "+ (r+1) + ", " + (c+1));
            }
        }
        System.out.println("----------answer----------\n");
    }

}