class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        int maxlen = 0;
        int c = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Ignore duplicates
            }

            if (i > 0 && nums[i] == nums[i - 1] + 1) {
                c++;
            } else {
                c = 1;
            }

            maxlen = Math.max(maxlen, c);
        }

        return maxlen;
    }
}