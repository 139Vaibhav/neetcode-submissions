class Solution {
    public int maxSubArray(int[] nums) {
        // Use kadanes algorithm
        int n = nums.length;
        int maxSoFar=nums[0];
        int curMax=nums[0];
        for(int i=1;i<n;i++){
            curMax = Math.max(curMax+nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, curMax);
        }
        return maxSoFar;
    }
}
