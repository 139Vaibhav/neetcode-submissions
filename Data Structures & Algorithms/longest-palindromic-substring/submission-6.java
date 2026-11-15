class Solution {
    int dp[][];
    boolean isPallindrome(String s, int i, int j){
        if(i>=j) return true;
        if(dp[i][j]!=-1){
            if (dp[i][j]==0) return false;
            else return true;
        }
        if(s.charAt(i)!=s.charAt(j)){
            dp[i][j]=0;
            return false;
        }
        
        boolean result = isPallindrome(s,i+1,j-1);

        if(result){
            dp[i][j]=1;
            return true;
        }
        else{
            dp[i][j]=0;
            return false;
        }
    }
    public String longestPalindrome(String s) {
        // dp has 3 states, -1,0,1
        // -1 -> not calculated
        // 0 -> not a pallindrome
        // 1 -> a pallindrome

        int n = s.length();
        int maxLen=0;
        String ans="";
        dp = new int[n][n];
        for(int[] x : dp)
            Arrays.fill(x, -1);

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPallindrome(s,i,j)){
                    int len = j-i+1;
                    if(len > maxLen){
                        maxLen = len;
                        ans = s.substring(i,j+1);
                    }
                }

            }
        }
        return ans;
    }
}
