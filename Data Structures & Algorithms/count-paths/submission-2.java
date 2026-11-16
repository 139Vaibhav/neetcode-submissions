class Solution {
    int cnt;
    int dp[][];

    int rec(int i, int j, int n, int m){
        if(i>=n || j>=m) return 0;
        if(i==n-1 && j==m-1){
            return dp[i][j]=1;
        }

        if(dp[i][j]!=-1) return dp[i][j];
        // down
        int down = rec(i+1,j,n,m);

        // right
        int right = rec(i,j+1,n,m);

        return dp[i][j]=down+right;
    }
    public int uniquePaths(int m, int n) {
        // down, right
        // (0,0) -> (n-1,m-1)
        cnt=0;
        dp = new int[m][n];
        for(int[] x:dp)
            Arrays.fill(x,-1);
        return rec(0,0,m,n);
    }
}
