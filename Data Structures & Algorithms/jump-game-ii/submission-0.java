class Solution {
    int dp[];
    int rec(int idx, int[] nums){
        if(idx>=nums.length) return Integer.MAX_VALUE/2;
        if(idx==nums.length-1)
            return 0;
        if(dp[idx]!=-1) return dp[idx];
        int step = Integer.MAX_VALUE/2;
        for(int i=idx+1;i<=idx+nums[idx];i++){
            step = Math.min(step, 1+rec(i,nums));
        }
        return dp[idx]=step;
    }
    public int jump(int[] nums) {
        // At any given idx, I will store the min steps to reach there
        int n = nums.length;
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return rec(0,nums);
    }
}
