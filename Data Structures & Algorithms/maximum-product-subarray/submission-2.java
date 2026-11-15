class Solution {
    public int maxProduct(int[] nums) {
        
        int minSoFar=nums[0];
        int maxSoFar=nums[0];
        int result = maxSoFar;
        for(int i=1;i<nums.length;i++){
            // 2 conditions
            // take the cur and carry on
            // start new subarray from cur
            int curr = nums[i];
            int tempMax = Math.max(curr, Math.max(maxSoFar * curr, minSoFar * curr));
            minSoFar = Math.min(curr, Math.min(maxSoFar * curr, minSoFar * curr));
            maxSoFar = tempMax;
            result = Math.max(result, maxSoFar);
        }
        return result;
    }
}
