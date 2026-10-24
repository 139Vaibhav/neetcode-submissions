class Solution {
    boolean isRow(char[][] board){
        int B[][] = new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    System.out.println(board[i][j]);
                int x = board[i][j]-'0';
                System.out.println(x);
                if(B[i][x-1]!=0)
                    return false;
                else
                    B[i][x-1]=1;
                }
            }
        }
        return true;
    }
    boolean isCol(char[][] board){
        int B[][] = new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                int x = board[i][j]-'0';
                if(B[j][x-1]!=0)
                    return false;
                else
                    B[j][x-1]=1;
                }
            }
        }
        return true;
    }
    boolean isBox(char[][] board){
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                int B[] = new int[9];
                for(int k=0;k<3;k++){
                    for(int l=0;l<3;l++){
                        if(board[i+k][j+l]!='.'){
                        int x = board[i+k][j+l]-'0';
                        if(B[x-1]!=0)
                            return false;
                        else
                            B[x-1]=1;
                        }
                    }
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        return isRow(board) && isCol(board) && isBox(board);
    }
}
