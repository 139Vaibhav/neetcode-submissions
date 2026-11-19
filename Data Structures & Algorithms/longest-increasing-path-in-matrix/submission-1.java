class Solution {
    int rec(int i, int j, int n, int m, int[][] vis, int[][] matrix){
        if(i<0 || j<0 || i>=n || j>=m) return 0;
        
        if(vis[i][j]!=-1) return vis[i][j];
        int p1=0, p2=0, p3=0, p4=0;
        if(i+1<n && matrix[i+1][j]>matrix[i][j])
            p1=1+rec(i+1,j,n,m,vis,matrix);
        if(j+1<m && matrix[i][j+1]>matrix[i][j])
            p2=1+rec(i,j+1,n,m,vis,matrix);
        if(i-1>=0 && matrix[i-1][j]>matrix[i][j])
            p3=1+rec(i-1,j,n,m,vis,matrix);
        if(j-1>=0 && matrix[i][j-1]>matrix[i][j])
            p4=1+rec(i,j-1,n,m,vis,matrix);
        
        return vis[i][j]=Math.max(p1,Math.max(p2, Math.max(p3,p4)));
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int vis[][] = new int[n][m];
        for(int x[] : vis)
            Arrays.fill(x, -1);
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans = Math.max(ans, 1+rec(i,j,n,m,vis,matrix));
            }
        }
        return ans;
    }
}
