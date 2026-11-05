class KthLargest {
    // k = 3 
    // [1,2,3,3]
    // [1,2,3,3,3] -> 3
    // [1,2,3,3,3,5] -> 3
    // [1,2,3,3,3,5,6] -> 3
    // [1,2,3,3,3,5,6,7] ->5
    PriorityQueue<Integer> pq;
    int key;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(Collections.reverseOrder());
        key=k;
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        int temp = key-1;
        List<Integer> t = new ArrayList<>();
        while(!pq.isEmpty() && temp > 0){
            // System.out.println("temp = "+temp+" k-th largest = "+pq.peek()+" ");
            t.add(pq.poll());
            temp--;
        }
        int ans = pq.peek();
        for(int x : t)
            pq.add(x);
        return ans;

    }
}
