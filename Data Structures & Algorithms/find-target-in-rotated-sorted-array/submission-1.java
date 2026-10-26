class Solution {
    public int search(int[] nums, int target) {
        int lo=0, hi=nums.length-1;
        int n = nums.length;
        int pivot = Integer.MAX_VALUE;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[hi])
                lo = mid + 1;
            else
                hi = mid;
        }
        pivot = lo;
        System.out.println("pivot is "+pivot);
        // check in first half
        lo=0; hi=pivot-1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target)
                lo=mid+1;
            else
                hi=mid-1;
        }

        lo=pivot; hi=n-1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target)
                lo=mid+1;
            else
                hi=mid-1;
        }

        return -1;
    }
}
