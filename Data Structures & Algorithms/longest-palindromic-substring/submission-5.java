
class Solution {

    int[][] dp;

    boolean isPalindrome(String s, int i, int j) {

        // Base cases
        if (i >= j) return true;

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        // First and last characters must match
        if (s.charAt(i) != s.charAt(j)) {
            dp[i][j] = 0;
            return false;
        }

        // Check the inner substring
        boolean result = isPalindrome(s, i + 1, j - 1);

        dp[i][j] = result ? 1 : 0;

        return result;
    }

    public String longestPalindrome(String s) {

        int n = s.length();

        dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int maxLen = 0;
        String ans = "";

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                if (isPalindrome(s, i, j)) {

                    int len = j - i + 1;

                    if (len > maxLen) {
                        maxLen = len;
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }

        return ans;
    }
}
