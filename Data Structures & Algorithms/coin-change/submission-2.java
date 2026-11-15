class Solution {
    int dp[][];

    int rec(int n, int amount, int[] coins){
        if(amount==0){
            return 0;
        }
        
        if(n<0) return Integer.MAX_VALUE/2;

        if(dp[n][amount]!=-1)
            return dp[n][amount];
        
        // take
        int take = Integer.MAX_VALUE/2;
        if(coins[n]<=amount){
            take = 1+rec(n,amount-coins[n],coins);
        }

        // not take
        int nottake = rec(n-1,amount,coins);
        return dp[n][amount] = Math.min(take, nottake);
    }
    public int coinChange(int[] coins, int amount) {
        // 15 [2,3,4,10]

        int n = coins.length;
        dp = new int[n][amount+1];
        for(int[] x:dp)
            Arrays.fill(x,-1);
        int res = rec(n-1,amount,coins);
        if(res==Integer.MAX_VALUE/2) return -1;
        else return res;
    }
}
