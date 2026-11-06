class Solution {
    void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    int quickSelect(int[] nums, int left, int right, int req){
        int pivot=left;
        for(int i=left;i<right;i++){
            if(nums[i]<=nums[right]){
                swap(nums, pivot, i);
                pivot++;
            }
        }
        swap(nums, pivot, right);
        if(pivot > req)
            return quickSelect(nums, left, pivot-1, req);
        else if(pivot < req)
            return quickSelect(nums, pivot+1, right, req);
        else return nums[pivot];
    }
    public int findKthLargest(int[] nums, int k) {
        // Use Quick Select
        // [2,3,1,5,4]
        int n = nums.length;
        int req = n-k;
        return quickSelect(nums, 0, n-1, req);
    }
}
