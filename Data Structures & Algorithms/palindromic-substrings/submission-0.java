class Solution {
    int cnt;
    int dp[][];

    boolean isPallindrome(String s, int i, int j){
        if(i>=j) return true;
        if(dp[i][j]!=-1){
            if(dp[i][j]==0) return false;
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
    public int countSubstrings(String s) {
        // 3 states
        // -1 ->unvisited, 0 -> visisted but not pallindrome, 1 -> 1 visited and pallindrome
        int n = s.length();
        dp = new int[n][n];
        for(int[] x : dp)
            Arrays.fill(x,-1);
        cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPallindrome(s,i,j))
                    cnt++;
            }
        }
        return cnt;
    }
}
