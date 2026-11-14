class Solution {
    int ans[];
    int rec(int idx, int n, int[] cost){
        if(idx>=n) return 0;
        if(ans[idx]!=-1) return ans[idx];
        return ans[idx] = cost[idx]+ Math.min(rec(idx+1, n, cost), rec(idx+2, n, cost));
    }
    public int minCostClimbingStairs(int[] cost) {
        // At every place we've 2 options
        // i+1, i+2 
        int n = cost.length;
        ans = new int[n];
        Arrays.fill(ans, -1);
        return Math.min(rec(0,n,cost), rec(1,n,cost));
    }
}
