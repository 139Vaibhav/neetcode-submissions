class Solution {
    int dp[][];
    int rec(int i, int j, int n, int m, String s, String t){
        if(j>=m) return 1;
        if(i>=n) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int take = 0;
        if(s.charAt(i)==t.charAt(j)){
            take = rec(i+1, j+1, n, m, s, t);
        }
        int nottake = rec(i+1, j, n, m, s, t);
        return dp[i][j]=take+nottake;
    }
    public int numDistinct(String s, String t) {
        // s="caaat"
        // t="cat"
        int n = s.length();
        int m = t.length();
        dp = new int[n+1][m+1];
        for(int[] x:dp)
            Arrays.fill(x, -1);
        return rec(0,0,n,m,s,t);
    }
}
