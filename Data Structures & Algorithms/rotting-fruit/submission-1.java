class Solution {
    public int orangesRotting(int[][] grid) {
        // 0-empty
        // 1-fresh fruit
        // 2-rotten fruit
        // Use a multisource BFS from all the rotten fruits
        // I will modify the structure ->
        // 0-rotten - begin point
        // Integer.MAX_VALUE - fresh fruit
        // -1 empty space
        // So if at the end we are left with any Integer.MAX_VALUE, then return -1
        int n = grid.length;
        int m = grid[0].length;
        int cnt0=0, cnt1=0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    grid[i][j]=-1;
                    cnt0++;
                }
                else if(grid[i][j]==1){
                    grid[i][j]=Integer.MAX_VALUE;
                    cnt1++;
                }
                else if(grid[i][j]==2){
                    grid[i][j]=0;
                    q.add(new int[]{i,j});
                }
            }
        }
        if(q.isEmpty()){
            if(cnt1 != 0) return -1;
            else return 0;
        }
        while(!q.isEmpty()){
            int pos[] = q.poll();
            int i=pos[0];
            int j=pos[1];
            if(i+1<n && grid[i+1][j]==Integer.MAX_VALUE){
                q.add(new int[]{i+1,j});
                grid[i+1][j]=grid[i][j]+1;
            }
            if(j+1<m && grid[i][j+1]==Integer.MAX_VALUE){
                q.add(new int[]{i,j+1});
                grid[i][j+1]=grid[i][j]+1;
            }
            if(i-1>=0 && grid[i-1][j]==Integer.MAX_VALUE){
                q.add(new int[]{i-1,j});
                grid[i-1][j]=grid[i][j]+1;
            }
            if(j-1>=0 && grid[i][j-1]==Integer.MAX_VALUE){
                q.add(new int[]{i,j-1});
                grid[i][j-1]=grid[i][j]+1;
            }
        }
        int maxVal=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==Integer.MAX_VALUE)
                    return -1;
                else
                    maxVal = Math.max(maxVal, grid[i][j]);
            }
        }
        return maxVal;
    }
}
