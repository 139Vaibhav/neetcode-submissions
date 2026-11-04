class Solution {
    boolean possible;
    void rec(int idx, int i, int j, int n, int m, char[][] board, boolean[][] vis, String word){
        if(idx==word.length()){
            possible=true;
            return;
        }
        if(i<0 || i>=n || j<0 || j>=m || vis[i][j]==true || board[i][j]!=word.charAt(idx)) return;
        
        vis[i][j]=true;
        rec(idx+1, i+1, j, n, m, board, vis, word);
        rec(idx+1, i-1, j, n, m, board, vis, word);
        rec(idx+1, i, j+1, n, m, board, vis, word);
        rec(idx+1, i, j-1, n, m, board, vis, word);
        vis[i][j]=false;
    }
    public boolean exist(char[][] board, String word) {
        // basically from any given index (i,j) -> we can move in all 4 directions
        // hence we need to maintain a visited array 
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        possible = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                rec(0,i,j,n,m,board,vis,word);
                if(possible==true) return true;
            }
        }
        return false;
    }
}
