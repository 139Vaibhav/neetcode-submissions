class Solution {
    int dp1[];
    int dp2[];
    int rec1(int idx, int n, int[] nums){
        if(idx>=n) return 0;
        if(dp1[idx]!=-1) return dp1[idx];
        int take = nums[idx] + rec1(idx+2, n, nums);
        int skip = rec1(idx+1, n, nums);
        return dp1[idx] = Math.max(take, skip);
    }
    int rec2(int idx, int n, int[] nums){
        if(idx>=n) return 0;
        if(dp2[idx]!=-1) return dp2[idx];
        int take = nums[idx] + rec2(idx+2, n, nums);
        int skip = rec2(idx+1, n, nums);
        return dp2[idx] = Math.max(take, skip);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        dp1 = new int[n];
        dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        int ans1=rec1(0,n-1,nums);
        int ans2=rec2(1,n,nums);
        return Math.max(ans1,ans2);
    }
}
