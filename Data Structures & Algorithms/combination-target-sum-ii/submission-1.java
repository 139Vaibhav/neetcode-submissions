class Solution {
    List<List<Integer>> ans;
    void rec(int idx, int target, List<Integer> l, int[] nums){
        if(target==0){
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            if(nums[i] > target) break;
            if(i>idx && nums[i]==nums[i-1]) continue;

            // include
            l.add(nums[i]);
            rec(i+1,target-nums[i],l,nums);
            l.removeLast();
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Algorithm - use a hashset and sort the numbers
        ans = new ArrayList<>();

        Arrays.sort(candidates);
        rec(0,target,new ArrayList<>(),candidates);

        return ans;
    }
}
