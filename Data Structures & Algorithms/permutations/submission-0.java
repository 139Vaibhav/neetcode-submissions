class Solution {
    List<List<Integer>> ans;
    void rec(List<Integer> l, int[] nums, boolean[] pick){
        if(l.size()==nums.length){
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!pick[i]){
                l.add(nums[i]);
                pick[i]=true;
                rec(l, nums, pick);
                l.removeLast();
                pick[i]=false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        // swap the numbers
        ans = new ArrayList<>();
        boolean[] pick = new boolean[nums.length];
        rec(new ArrayList<>(), nums, pick);
        return ans;
    }
}
