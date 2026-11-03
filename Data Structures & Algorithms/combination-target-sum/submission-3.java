class Solution {
    List<List<Integer>> ans;
    void rec(int idx, int target, List<Integer> l, int[] nums){
        if(target==0){
            ans.add(new ArrayList<>(l));
            return;
        }
        if(target<0 || idx>=nums.length) return;
        for(int i=idx; i<nums.length; i++){
            l.add(nums[i]);
            rec(i,target-nums[i],l,nums);
            l.removeLast();
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        rec(0,target,new ArrayList<>(),nums);
        return ans;
    }
}
