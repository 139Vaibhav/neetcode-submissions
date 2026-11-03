class Solution {
    List<List<Integer>> ans;
    Set<List<Integer>> st;
    void rec(int idx, int target, List<Integer> l, int[] nums){
        if(target==0){
            st.add(new ArrayList<>(l));
            return;
        }
        if(target<0 || idx>= nums.length) return;

        // include and move fwd
        l.add(nums[idx]);
        rec(idx+1, target-nums[idx], l, nums);

        // include and stay
        rec(idx, target-nums[idx], l, nums);
        
        //// do not include
        l.removeLast();
        rec(idx+1, target, l, nums);

    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // [2,5,6,9]
        // at every index - take, not take
        // rec(0, target, list, nums)
        // 3 options - include and move fwd
        //           - include and stay
        //           - not include and move fwd
        ans = new ArrayList<>();
        st = new HashSet<>();
        rec(0, target, new ArrayList<>(), nums);
        for(List<Integer> x : st)
            ans.add(x);
        return ans;
    }
}
