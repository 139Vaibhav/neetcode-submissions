class Solution {
    boolean pacific(int i, int j, int n, int m, int[][] heights, boolean[][] vis){
        vis[i][j]=true;
        if(i==0 || j==0) return true;
        // all 4 directions
        boolean a=false, b=false, c=false, d=false;
        if(i+1<n && heights[i+1][j]<=heights[i][j] && !vis[i+1][j])
            a = pacific(i+1,j,n,m,heights,vis);
        if(i-1>=0 && heights[i-1][j]<=heights[i][j] && !vis[i-1][j])
            b = pacific(i-1,j,n,m,heights,vis);
        if(j+1<m && heights[i][j+1]<=heights[i][j] && !vis[i][j+1])
            c = pacific(i,j+1,n,m,heights,vis);
        if(j-1>=0 && heights[i][j-1]<=heights[i][j] && !vis[i][j-1])
            d = pacific(i,j-1,n,m,heights,vis);
        return (a || b || c || d);

    }
    boolean atlantic(int i, int j, int n, int m, int[][] heights, boolean[][] vis){
        vis[i][j]=true;
        if(i==n-1 || j==m-1) return true;
        // all 4 directions
        boolean a=false, b=false, c=false, d=false;
        if(i+1<n && heights[i+1][j]<=heights[i][j] && !vis[i+1][j])
            a = atlantic(i+1,j,n,m,heights,vis);
        if(i-1>=0 && heights[i-1][j]<=heights[i][j] && !vis[i-1][j])
            b = atlantic(i-1,j,n,m,heights,vis);
        if(j+1<m && heights[i][j+1]<=heights[i][j] && !vis[i][j+1])
            c = atlantic(i,j+1,n,m,heights,vis);
        if(j-1>=0 && heights[i][j-1]<=heights[i][j] && !vis[i][j-1])
            d = atlantic(i,j-1,n,m,heights,vis);
        return (a || b || c || d);

    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // Few Observations ->
        //  i==0, j==0 -> pacific
        //  i==n-1, j==m-1 -> atlantic
        //  so for any (i,j) -> can it reach->
        //  (i==0 || j==0 && i==n-1 || j==m-1)
        //  Algorithm -> Do DFS for each (i,j) and check if above condition can be met -> TC((n*m)*O(n*m))= O(n*m)^2
        List<List<Integer>> ans = new ArrayList<>();
        int n=heights.length;
        int m=heights[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                boolean[][] vis1 = new boolean[n][m];
                boolean[][] vis2 = new boolean[n][m];
                if(pacific(i,j,n,m,heights,vis1) && atlantic(i,j,n,m,heights,vis2))
                    ans.add(new ArrayList<>(List.of(i,j)));
            }
        }
        return ans;
    }
}
