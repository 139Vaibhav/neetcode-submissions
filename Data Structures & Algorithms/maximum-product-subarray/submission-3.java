class Solution {
    public int maxProduct(int[] nums) {
        int maxSoFar=nums[0];
        int minSoFar=nums[0];
        int res = nums[0];
        for(int x : nums){
            res = Math.max(res, x);
        }
        for(int i=1;i<nums.length;i++){
            int cur = nums[i];
            if(cur==0){
                minSoFar=1;
                maxSoFar=1;
            }
            else{
                // since we are recomputing the maxSofar, therefore we need to store it in some temp variable
                int temp = maxSoFar;
                maxSoFar = Math.max(cur, Math.max(maxSoFar*cur, minSoFar*cur));
                minSoFar = Math.min(cur, Math.min(temp*cur, minSoFar*cur));  
                res = Math.max(res, maxSoFar); 
            }
        }
        return res;
    }
}
