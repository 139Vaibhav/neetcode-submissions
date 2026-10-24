class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //[-1,0,1,2,-1,-4] -> [-4,-1,-1,0,1,2]
        // 
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> st = new HashSet<>();

        int n = nums.length;
        for(int i=0;i<n;i++){
            int target = -1*(nums[i]);
            int left = i+1;
            int right = n-1;
            while(left<right){
                if(nums[left]+nums[right]==target){
                    st.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));
                    left++;
                    right--;
                }
                else if(nums[left]+nums[right]<target)
                    left++;
                else
                    right--;
            }
        }
        for(List<Integer> x : st){
            ans.add(x);
        }
        return ans;
    }
}
