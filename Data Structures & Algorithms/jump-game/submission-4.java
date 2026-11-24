class Solution {
    int dp[];
    int rec(int idx, int[] nums){
        if(idx>=nums.length) return 0;

        if(idx==nums.length-1){
            return dp[idx]=1;
        }

        if(dp[idx]!=-1) return dp[idx];

        for(int i=idx+1;i<=idx+nums[idx] && i<nums.length;i++){
            if(rec(i,nums)==1)
                return dp[idx]=1;
        }
        return dp[idx]=0;
    }
    public boolean canJump(int[] nums) {
        if(nums[0]==0){
            if(nums.length > 1) return false;
            else return true;
        }
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        int x = rec(0,nums);
        if(dp[n-1]==1) return true;
        else return false;
    }
}
