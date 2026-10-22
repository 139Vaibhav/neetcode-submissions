class Solution {
    public int[] twoSum(int[] nums, int target) {
        // basic algorithm - TC - O(n^2)
        // Using a map (3,4,5,6), target=7
        // mp [(3,0), (4,1), (5,2), (6,3)]
        // [0,1]
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i], i);
        }
        int[] ans = new int[2];
        for(int i=0;i<nums.length;i++){
            int k = target-nums[i];
            if(mp.containsKey(k) && mp.get(k)!=i){
                return new int[]{i,mp.get(k)};
            }
        }
        return new int[0];
    }
}
