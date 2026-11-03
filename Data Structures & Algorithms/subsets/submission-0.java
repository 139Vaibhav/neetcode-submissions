class Solution {
    List<List<Integer>> ans;
    void rec(int start, int[] nums, List<Integer> l) {
        ans.add(new ArrayList<>(l)); // Capture snapshot
        for (int i = start; i < nums.length; i++) {
            l.add(nums[i]);          // Move forward
            rec(i + 1, nums, l);     // Recurse
            l.removeLast();          // Backtrack
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        rec(0, nums, new ArrayList<>());
        return ans;
    }
}