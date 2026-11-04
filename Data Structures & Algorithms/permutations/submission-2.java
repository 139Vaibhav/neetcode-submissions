class Solution {
    List<List<Integer>> ans;
    void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    void rec(int idx, int[] nums){
        if(idx==nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int x: nums)
                temp.add(x);
            ans.add(temp);
            return;
        }
        for(int i=idx;i<nums.length;i++){
            swap(nums, idx, i);
            rec(idx+1, nums);
            swap(nums, idx, i);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        rec(0, nums);
        return ans;
    }
}
