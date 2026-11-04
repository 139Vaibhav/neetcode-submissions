class Solution {
    List<List<Integer>> ans;
    void rec(int idx, int[] nums, List<Integer> l, boolean[] pick){
        if(l.size()==nums.length){
            ans.add(new ArrayList<>(l));
            return;
        }
        if(idx>=nums.length)
            return;
        for(int i=0;i<nums.length;i++){
            if(pick[i]==false){
                l.add(nums[i]);
                pick[i]=true;
                rec(i, nums, l, pick);
                pick[i]=false;
                l.removeLast();
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        // for permutations
        ans = new ArrayList<>();
        boolean[] pick = new boolean[nums.length];
        rec(0, nums, new ArrayList<>(), pick);
        return ans;
    }
}
