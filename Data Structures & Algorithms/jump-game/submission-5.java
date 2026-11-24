class Solution {
    public boolean canJump(int[] nums) {
        // Greedy Approach
        int l=0;
        int r=nums[0];
        int n = nums.length;
        while(l<=r && l<n){
            r = Math.max(r, l+nums[l]);
            l++;
        }
        if(r>=n-1) return true;
        else return false;
    }
}
