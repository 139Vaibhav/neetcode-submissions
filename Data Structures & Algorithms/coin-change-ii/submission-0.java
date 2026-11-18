class Solution {
    int dp[][];
    int rec(int idx, int sum, int amount, int n, int[] coins){
        if(idx>=n){
            if(sum==amount)
                return 1;
            return 0;
        }
        if(sum>amount) return 0;
        if(sum==amount){
            return 1;
        }
        if(dp[idx][sum]!=-1)
            return dp[idx][sum];

        // take
        int take = rec(idx,sum+coins[idx],amount,n,coins);

        // not take
        int nottake = rec(idx+1,sum,amount,n,coins);
        return dp[idx][sum] = take+nottake;
    }
    public int change(int amount, int[] coins) {
        // number of ways a given amount can be reached
        // at every step I will have the option to take or not take
        int n = coins.length;
        dp = new int[n+1][amount+1];
        for(int[] x : dp)
            Arrays.fill(x, -1);
        return rec(0,0,amount,n,coins);
    }
}
