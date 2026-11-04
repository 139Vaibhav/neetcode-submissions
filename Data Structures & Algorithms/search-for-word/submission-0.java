class Solution {
    boolean possible;
    void rec(int i, int j, int n, int m, StringBuilder sb, char[][] board, boolean[][] vis, String word){
        if(sb.toString().equals(word)){
            possible=true;
            return;
        }
        if(i<0 || i>=n || j<0 || j>=m || vis[i][j]==true) return;
        sb.append(board[i][j]);
        vis[i][j]=true;
        rec(i+1, j, n, m, sb, board, vis, word);
        rec(i-1, j, n, m, sb, board, vis, word);
        rec(i, j+1, n, m, sb, board, vis, word);
        rec(i, j-1, n, m, sb, board, vis, word);
        vis[i][j]=false;
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1); // Removes the last character
        }
    }
    public boolean exist(char[][] board, String word) {
        // basically from any given index (i,j) -> we can move in all 4 directions
        // hence we need to maintain a visited array 
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        possible = false;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                rec(i,j,n,m,sb,board,vis,word);
                if(possible==true) return true;
            }
        }
        return false;
    }
}
