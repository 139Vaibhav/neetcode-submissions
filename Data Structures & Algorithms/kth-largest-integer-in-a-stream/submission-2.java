class KthLargest {
    // Optimized priority queue - use a min heap, and only insert "k" elements
    // This will ensure that the 1st number is the k-th largest. 
    // If a number smaller than kth largest comes then no need to store it 

    PriorityQueue<Integer> pq;
    int key;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k) pq.poll();
        }
        key=k;
    }

    public int add(int val) {
        pq.add(val);
        if(pq.size()>key)
            pq.poll();
        return pq.peek();
    }
}
