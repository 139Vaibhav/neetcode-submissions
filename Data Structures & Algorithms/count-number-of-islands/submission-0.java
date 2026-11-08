class Solution {
    int ans;
    void rec(int i, int j, int n, int m, char[][] grid){
        grid[i][j]='2';
        if(i+1 < n && grid[i+1][j]=='1')
            rec(i+1, j, n, m, grid);
        if(j+1 < m && grid[i][j+1]=='1')
            rec(i, j+1, n, m, grid);
        if(i-1 >=0 && grid[i-1][j]=='1')
            rec(i-1, j, n, m, grid);
        if(j-1 >= 0 && grid[i][j-1]=='1')
            rec(i, j-1, n, m, grid);
        return;
    }
    public int numIslands(char[][] grid) {
        ans=0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    System.out.println("i= "+i+" j= "+j);
                    rec(i,j,n,m,grid);
                    ans++;
                }
            }
        }
        return ans;
    }
}
