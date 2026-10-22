class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            mp.put(nums[i], mp.getOrDefault(nums[i],0)+1);
        }
        for(int x:mp.values()){
            if(x>1)
                return true;
        }
        return false;
    }
}