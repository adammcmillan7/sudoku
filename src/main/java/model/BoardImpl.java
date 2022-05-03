package model;



public class BoardImpl {
    private int[][] board;
    private int[][] status;

    public BoardImpl(int[][] board){
        this.board = board;
        this.status = new int[9][9];

        for (int r = 0;r< 9;r++){
            for (int c=0;c< 9;c++){
                if (board[r][c] !=0){
                    status[r][c] = 2;
                }
                else status[r][c] = 0;
            }
        }
    }

    public boolean isSolved(){
        for (int r=0;r<9;r++){
            if (!isRowLegal(r)){
                return false;
            }
        }
        for (int c=0;c<9;c++){
            if (!isColumnLegal(c)){
                return false;
            }
        }
        for (int i=0,j=0;i<9;){
            if (!isGridLegal(i,j)){
                return false;
            }
            i +=3;
            j +=3;
        }
        return true;
    }


    public void removeNum(int r, int c){
        if (isClue(r,c)){
            return;
        }
        board[r][c] = 0;
        status[r][c] = 0;

    }

    public void reset(){

        for (int r=0;r<9;r++){
            for (int c=0;c<9;c++){
                if (status[r][c] != 2){
                    board[r][c] = 0;
                    status[r][c] = 0;
                }
            }
        }

    }

    public void editNum(int r, int c, int value){
        if (isClue(r,c)){
            return;
        }
        board[r][c] = value;
        status[r][c] = 1;
    }

    public boolean isRowLegal(int r){
        int[] row = board[r];
        int[] found = new int[9];

        for (int i=0;i<9;i++){
            for (int c=0;c<9;c++){
                if (row[c] == 0){
                    return false;
                }
                if (row[c] == i+1){
                    if (found[i] == 1){
                        return false;
                    }
                    found[i] = 1;
                }
            }
        }
        return true;
    }

    public boolean isColumnLegal(int c){
        int[] found = new int[9];

        for (int i=0;i<9;i++){
            for (int r=0;r<9;r++){
                if (board[r][c] == 0){
                    return false;
                }
                if (board[r][c] == i+1){
                    if (found[i] == 1){
                        return false;
                    }
                    found[i] = 1;
                }
            }
        }
        return true;
    }

    /** grid is a 3x3 square, input r,c is the upper left corner **/
    public boolean isGridLegal(int r, int c){
        int[] found = new int[9];

        for (int i=r;i<r+3;i++){
            for (int j=c;j<c+3;j++){
                if (board[i][j] == 0){
                    return false;
                }
                if (board[i][j] == i+1){
                    if (found[i] == 1){
                        return false;
                    }
                    found[i] = 1;
                }
            }
        }
        return true;
    }

    public int getValue(int r, int c){
        if(isEmpty(r,c)){
            return 0;
        }
        return board[r][c];
    }

    public boolean isClue(int r, int c){
        if (status[r][c] == 2){
            return true;
        }
        return false;
    }

    private boolean isEmpty(int r, int c){
        if (status[r][c] == 0){
            return true;
        }
        return false;
    }
}