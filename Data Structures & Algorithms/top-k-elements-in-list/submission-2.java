class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Use a min heap this time
        Map<Integer,Integer> mp = new HashMap<>();
        int n = nums.length;
        
        List<List<Integer>> l = new ArrayList<>();
        // at index x (I'm assuming x as the freq and the value as the count of times that number has appeared)
        
        for(int i=0;i<n;i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
        }
        
        for(int i=0;i<=n;i++)
            l.add(new ArrayList<>());

        for(int x : mp.keySet()){
            int freq = mp.get(x);
            l.get(freq).add(x);
        }
        int ans[] = new int[k];
        int idx =0;
        for(int i=n;i>=1 && idx<k;i--){
            for (int x : l.get(i)) {
                ans[idx++] = x;
                if (idx == k)
                    break;
            }
        }
        return ans;
    }
}
