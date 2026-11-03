class Solution {
    List<List<Integer>> ans;
    void rec(int idx, int[] nums, List<Integer> l){
        // for(int i=0;i<l.size();i++)
        //     System.out.print(l.get(i)+" ");
        // System.out.println();
        
        if(idx>=nums.length){
            ans.add(new ArrayList<>(l));
            return;
        }
        // include
        l.add(nums[idx]);
        rec(idx+1, nums, l);
        // exclude
        l.removeLast();
        rec(idx+1, nums, l);
    }
    public List<List<Integer>> subsets(int[] nums) {
        // For all values in nums, there are two cases - include, not include
        ans = new ArrayList<>();
        rec(0, nums, new ArrayList<>());
        return ans;
    }
}
