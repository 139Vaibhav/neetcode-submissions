class Solution {
    List<List<Integer>> ans;
    void rec(int idx, List<Integer> l, int[] nums){
        
        ans.add(new ArrayList<>(l));
        
        for(int i=idx;i<nums.length;i++){
            // not include any of the occurences of nums[idx]
            if(i>idx && nums[i]==nums[i-1]) continue;

            // include
            l.add(nums[i]);
            rec(i+1, l, nums);
            l.removeLast();
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // [1,2,1] -> each number has 2 options - include, exclude
        // [1,1,2] -> sort it 
        // if I don't want to include a number, then I will not include any of its occurences that means I will kepp on skipping it in my right subtree 
        ans = new ArrayList<>();
        Arrays.sort(nums);
        rec(0, new ArrayList<>(), nums);
        return ans;
    }
}
