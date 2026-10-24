class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        int n = nums.length;
        int maxlen=0;
        for(int i=0;i<n;i++)
            st.add(nums[i]);
        for(int x : st){
            if(!st.contains(x-1)){
                int sz = 1;
                int temp = x;
                while(st.contains(temp+1)){
                    temp++;
                    sz++;
                }
            maxlen = Math.max(maxlen, sz);
            }
            
        }
        return maxlen;
    }
}
