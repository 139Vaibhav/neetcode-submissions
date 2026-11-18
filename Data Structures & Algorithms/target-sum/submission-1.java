class Solution {
    int dp[][];
    int totsum;
    int rec(int idx, int sum, int n, int target, int[] nums){
        if(idx>=n){
            if(sum==target)
                return 1;
            return 0;
        }

        if(dp[idx][totsum+sum]!=-1)
            return dp[idx][totsum+sum];
        // add
        int add = rec(idx+1, sum+nums[idx], n, target, nums);

        // subtract
        int sub = rec(idx+1, sum-nums[idx], n, target, nums);

        return dp[idx][totsum+sum] = add+sub;

    }
    public int findTargetSumWays(int[] nums, int target) {
        // At every index 2 cases, add or subtract the number, and maintain a totsum
        // the sum can be negative, therefore we should use an offset so that the sum state does not come as negative

        int n = nums.length;
        totsum=0;
        for(int x : nums)
            totsum+=x;
        dp = new int[n+1][2*totsum+1];
        for(int[] x : dp)
            Arrays.fill(x, -1);
        return rec(0,0,n,target,nums);
        
    }
}
