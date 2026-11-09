class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0)
                    q.add(new int[]{i,j});
            }
        }
        if(q.size()==0) return;
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int i = pos[0];
            int j = pos[1];
            if(i+1<n && grid[i+1][j]==Integer.MAX_VALUE){
                q.add(new int[]{i+1,j});
                grid[i+1][j]=grid[i][j]+1;
            }
            if(i-1>=0 && grid[i-1][j]==Integer.MAX_VALUE){
                q.add(new int[]{i-1,j});
                grid[i-1][j]=grid[i][j]+1;
            }
            if(j+1<m && grid[i][j+1]==Integer.MAX_VALUE){
                q.add(new int[]{i,j+1});
                grid[i][j+1]=grid[i][j]+1;
            }
            if(j-1>=0 && grid[i][j-1]==Integer.MAX_VALUE){
                q.add(new int[]{i,j-1});
                grid[i][j-1]=grid[i][j]+1;
            }
        }
        return;
    }
}
