class Solution {
    int maxArea;
    int cnt;
    void dfs(int i, int j, int n, int m, int[][] grid){
        cnt++;
        grid[i][j]=2;
        if(i+1 < n && grid[i+1][j]==1)
            dfs(i+1, j, n, m, grid);
        if(i-1 >=0 && grid[i-1][j]==1)
            dfs(i-1, j, n, m, grid);
        if(j+1 < m && grid[i][j+1]==1)
            dfs(i, j+1, n, m, grid);
        if(j-1 >= 0 && grid[i][j-1]==1)
            dfs(i, j-1, n, m, grid);
        maxArea = Math.max(maxArea, cnt);
        return;
    }
    public int maxAreaOfIsland(int[][] grid) {
        maxArea=0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    cnt=0;
                    // System.out.println("i= "+i+" j= "+j);
                    dfs(i,j,n,m,grid);
                }
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         System.out.print(grid[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return maxArea;
    }
}
