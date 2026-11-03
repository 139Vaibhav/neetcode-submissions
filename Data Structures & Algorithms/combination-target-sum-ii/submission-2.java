class Solution {
    List<List<Integer>> ans;
    void rec(int idx, int target, List<Integer> l, int[] nums){
        if(target==0){
            ans.add(new ArrayList<>(l));
            return;
        }
        if(target<0 || idx>=nums.length) return;

        // include
        l.add(nums[idx]);
        rec(idx+1, target-nums[idx], l, nums);
        l.removeLast();

        // not include - remove all the duplicates also of that number;
        int i=idx+1;
        while(i<nums.length && nums[i-1]==nums[i]){
            i++;
        }
        rec(i, target, l, nums);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        rec(0,target,new ArrayList<>(),candidates);
        return ans;
    }
}
