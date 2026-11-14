class Solution {
    int maxSum[];
    int rec(int idx, int n, int[] nums){
        if(idx >= n) return 0;
        if(maxSum[idx]!=-1) return maxSum[idx];
        int take = nums[idx]+rec(idx+2, n, nums);
        int skip = rec(idx+1, n, nums);
        return maxSum[idx]=Math.max(take, skip);
    }
    public int rob(int[] nums) {
        // 100 3 9 100
        // at any given index, it can take all the elements other than i-1 or i+1
        // [2,9,8,3,6]
        // maxSum=0, n=5
        // rec(0)-> 2 + 8 + 6 + 0
        // rec(1)
        int n = nums.length;
        maxSum=new int[n];
        Arrays.fill(maxSum, -1);
        return rec(0,n,nums);
    }
}
