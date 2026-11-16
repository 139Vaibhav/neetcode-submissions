class Solution {
    int dp[][];

    int rec(int idx, int prevIdx, int[] nums){
        if(idx==nums.length){
            return 0;
        }

        if(dp[idx][prevIdx+1]!=-1)
            return dp[idx][prevIdx+1];

        // take
        int take = 0;
        if(prevIdx == -1 || nums[idx] > nums[prevIdx]){
            take = 1+rec(idx+1,idx,nums);
        }

        // not take 
        int nottake = rec(idx+1, prevIdx, nums);

        return dp[idx][prevIdx+1] = Math.max(take, nottake);
    }
    public int lengthOfLIS(int[] nums) {
        // at every index we have the option to choose and not choose
        // 2 states, idx, curlen
        int n = nums.length;
        dp = new int[n+1][n+1];
        for(int[] x : dp)
            Arrays.fill(x, -1);
        return rec(0,-1,nums);
    }
}
