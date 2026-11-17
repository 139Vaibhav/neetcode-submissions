class Solution {
    int[][] dp;
    int rec(int idx, int canBuy, int n, int[] prices){
        if(idx>=n){
            return 0;
        }
        if(dp[idx][canBuy]!=-1)
            return dp[idx][canBuy];
            
        if(canBuy==1){
            // Math.max(buy, not buy)
            return dp[idx][canBuy] = Math.max(-prices[idx]+rec(idx+1,0,n,prices), rec(idx+1,1,n,prices));
        }
        else{
            // Math.max(sell, hold)
            return dp[idx][canBuy] =Math.max(prices[idx]+rec(idx+2,1,n,prices), rec(idx+1,0,n,prices));
        }
    }
    public int maxProfit(int[] prices) {
        // create a recursion
        // buy, sell
        // 2 states -> idx, canbuy
        int n = prices.length;
        dp = new int[n][2];
        for(int[] x : dp)
            Arrays.fill(x,-1);
        return rec(0,1,n,prices);
    }
}