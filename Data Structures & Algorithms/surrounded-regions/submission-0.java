class Solution {
    void dfs(int i, int j, int n, int m, char[][] board){
        board[i][j]='V';
        // go in all four directions
        if(i+1<n && board[i+1][j]=='O')
            dfs(i+1,j,n,m,board);
        if(j+1<m && board[i][j+1]=='O')
            dfs(i,j+1,n,m,board);
        if(i-1>=0 && board[i-1][j]=='O')
            dfs(i-1,j,n,m,board);
        if(j-1>=0 && board[i][j-1]=='O')
            dfs(i,j-1,n,m,board);
    }
    public void solve(char[][] board) {
        /*
        ["X","X","X","X"]
        ["X","X","O","X"]
        ["X","O","X","X"]
        ["X","O","X","X"]
        */
        // Just do a DFS from the border cells which have O
        // instrad of using a visited array, just change "O" to "V"
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || j==0 || i==n-1 || j==m-1) && board[i][j]=='O'){
                    dfs(i,j,n,m,board);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]!='V')
                    board[i][j]='X';
                else    
                    board[i][j]='O';
            }
        }
        return;
    }
}
