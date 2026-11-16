class Solution {
    int maxLen;
    int dp[][];
    int rec(int i, int j,int n, int m, String s1, String s2){
        if(i>=n || j>=m){
            return 0;
        }
        if(dp[i][j]!=-1)
            return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
            dp[i][j] = 1+rec(i+1,j+1,n,m,s1,s2);
        }
        else{
            dp[i][j] = Math.max(rec(i+1,j,n,m,s1,s2), rec(i,j+1,n,m,s1,s2));
        }
        return dp[i][j];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        // "cat", "crabt"
        // i, j
        // s1.charAt(i)==s.charAt(j) -> i+1, j+1
        // not equal case -> rec(i,j+1), rec(i+1,j)
        dp = new int[text1.length()+1][text2.length()+1];
        for(int[] x : dp)
            Arrays.fill(x,-1);
        return rec(0,0,text1.length(), text2.length(),text1,text2);
    }
}
