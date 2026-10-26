class Solution {
    public int findMin(int[] nums) {
        // [3,4,5,6,1,2]
        // lo=0, hi=5, mid=2, nums[mid]=5
        // lo=3, hi=5, mid=4, nums[mid]=1
        // lo=3, hi=3, mid=3, nums[mid]=6
        int i=0, n=nums.length;
        int lo=0, hi=n-1;
        int pivot = Integer.MAX_VALUE;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            // System.out.println("nums[mid] = "+nums[mid]);
            pivot = Math.min(pivot, nums[mid]);
            if(nums[mid] > nums[hi])
                lo=mid+1;
            else
                hi=mid-1;
        }
        return pivot;
    }
}
