class Solution {
    class Pair{
        int f;
        int s;
        Pair(int f, int s){
            this.f=f;
            this.s=s;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        // map and priority queue
        Map<Integer,Integer> mp = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.s-a.s);
        int n = nums.length;
        for(int i=0;i<n;i++){
            mp.put(nums[i], mp.getOrDefault(nums[i],0)+1);
        }
        for(int x : mp.keySet()){
            Pair p = new Pair(x, mp.get(x));
            pq.add(p);
        }
        int ans[] = new int[k];
        int i=0;
        while(k-- > 0){
            ans[i++]=pq.poll().f;
        }
        return ans;
    }
}
