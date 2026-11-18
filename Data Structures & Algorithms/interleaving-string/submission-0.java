class Solution {
    int[][] dp;

    boolean rec(int i, int j, String s1, String s2, String s3) {
        int k = i + j;
        
        // Base case: reached the end of s3
        if (k == s3.length()) {
            return true;
        }

        // Check if state is already memoized (-1 means unvisited)
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        boolean res = false;

        // Choice 1: Try matching with s1's character
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            res = res || rec(i + 1, j, s1, s2, s3);
        }

        // Choice 2: If s1 didn't work, try matching with s2's character
        if (!res && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            res = res || rec(i, j + 1, s1, s2, s3);
        }

        // Store result in DP table (1 for true, 0 for false)
        dp[i][j] = res ? 1 : 0;
        return res;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        // Quick length check
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return rec(0, 0, s1, s2, s3);
    }
}