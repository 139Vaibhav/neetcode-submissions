class Solution {

    int dp[][];

    int rec(int idx1, int idx2, int n, int m, String s1, String s2){
        if (idx1 == n) return m - idx2;
        if (idx2 == m) return n - idx1;

        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];

        int ans;

        // if the values match
        if(s1.charAt(idx1)==s2.charAt(idx2))
            ans = rec(idx1+1, idx2+1, n, m, s1, s2);
        else{
            // insert a character (idx1 will remain at the same place)
            int insert = 1+rec(idx1, idx2+1, n, m, s1, s2);

            // delete a character (idx1 will move ahead by 1 index, idx2 will remain at same place)
            int delete = 1+rec(idx1+1, idx2, n, m, s1, s2);

            // replace a character (both idx1, and idx2 will move)
            int replace = 1+rec(idx1+1, idx2+1, n, m, s1, s2);

            ans = Math.min(insert, Math.min(delete, replace));
        }
        return dp[idx1][idx2]=ans;
    }
    public int minDistance(String word1, String word2) {
        // insert
        // delete
        // replace
        // word1 - monkeys
        // word2 - money
        // Algorithm - At every index, if the chars do not match, then perform all the three operations and move to idx+1

        int n = word1.length();
        int m = word2.length();
        dp = new int[n+1][m+1];
        for(int[] x : dp)
            Arrays.fill(x, -1);
        return rec(0,0,n,m,word1,word2);
        
    }
}
