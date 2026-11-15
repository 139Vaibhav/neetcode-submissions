
class Solution {
    int dp[];

    int rec(int idx, int n, String s) {

        if(idx == n) {
            return 1;
        }
        if(dp[idx]!=-1) return dp[idx];

        // Cannot decode standalone zero
        if(s.charAt(idx) == '0') {
            return 0;
        }

        // Choice 1: Take one digit
        int take1 = rec(idx + 1, n, s);
        int take2 = 0;
        // Choice 2: Take two digits
        if(idx + 1 < n) {
            int num = Integer.parseInt(s.substring(idx, idx + 2));

            if(num >= 10 && num <= 26) {
                take2 = rec(idx + 2, n, s);
            }
        }
        return dp[idx]=take1+take2;
    }

    public int numDecodings(String s) {
        int n = s.length();
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return rec(0, n, s);
    }
}
