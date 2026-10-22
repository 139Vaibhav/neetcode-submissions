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
            if(mp.containsKey(target-nums[i])){
                ans[0]=Math.min(i,mp.get(target-nums[i]));
                ans[1]=Math.max(i,mp.get(target-nums[i]));
                if(ans[0]!=ans[1])
                    break;
            }
        }
        return ans;
    }
}
