class Solution {

    int robRange(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {
            int take = nums[i] + prev2;
            int skip = prev1;

            int curr = Math.max(take, skip);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int ans1 = robRange(nums, 0, n - 2);
        int ans2 = robRange(nums, 1, n - 1);

        return Math.max(ans1, ans2);
    }
}