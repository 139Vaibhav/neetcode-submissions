class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }
        int n = nums.length;
        int ans[] = new int[n-k+1];
        ans[0]=pq.peek();
        int i=0, j=k;
        while(j<n){
            pq.add(nums[j]);
            // System.out.println("added "+nums[j]);
            pq.remove(nums[i]);
            // System.out.println("remoed "+nums[i]);
            i++;
            // System.out.println("i="+i);
            if(i<n-k+1)
                ans[i]=pq.peek();
            j++;
        }
        return ans;
    }
}
