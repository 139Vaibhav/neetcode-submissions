class Solution {
    int dp[][][];
    int rec(int idx, int canBuy, int k, int n, int[] prices){
        if(idx>= n){
            return 0;
        }

        if(dp[idx][k][canBuy]!=-1)
            return dp[idx][k][canBuy];
        if(canBuy == 1){
            // buy or not buy
            return dp[idx][k][canBuy]=Math.max(-prices[idx]+rec(idx+1, 0, k, n, prices), rec(idx+1, 1, k, n, prices));
            
        }
        else if(k>0){
            // hold or sell
            return dp[idx][k][canBuy]=Math.max(prices[idx] + rec(idx+1, 1, k-1, n, prices), rec(idx+1, 0, k, n, prices));
            
        }
        return dp[idx][k][canBuy]=0;
    }
    public int maxProfit(int[] prices) {
        // at most k transactions
        // buy and sell
        // boolean canBuy -> true
        // buy -> store the bought index
        // canBuy -> false
        // sell -> store, change the bought index to -1
    
        int n = prices.length;
        int k=2;
        dp = new int[n][k+1][2];
        for(int[][] x1: dp){
            for(int[] x2 : x1)
                Arrays.fill(x2,-1);
        }
        return rec(0,1,2,n,prices);
    }
}