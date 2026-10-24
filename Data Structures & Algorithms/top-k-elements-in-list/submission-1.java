class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Use a min heap this time
        Map<Integer,Integer> mp = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int n = nums.length;
        for(int i=0;i<n;i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
        }
        for(int freq : mp.keySet()){
            pq.add(new int[]{mp.get(freq), freq});
            if(pq.size() > k)
                pq.poll();
        }
        int ans[] = new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq.poll()[1];
        }
        return ans;
    }
}
