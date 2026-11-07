class Solution {
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    int quickSelect(int[] nums, int req, int left, int right){
        // I am taking the pivot as the random element and replacing it with the rightmost element
        int randomIdx = left + (int)(Math.random() * (right - left + 1));
        swap(nums, randomIdx, right);
        
        int pivotIdx = left;
        for(int i=left; i<right; i++){
            if(nums[i]<=nums[right]){
                swap(nums, i, pivotIdx);
                pivotIdx++;
            }
        }
        // Now swap the pivot that is the rightmost element with the pivotIdx
        swap(nums, pivotIdx, right);
        
        // Now check if req is in the left part or right part of the pivot
        if(req < pivotIdx)
            return quickSelect(nums, req, left, pivotIdx-1);
        else if(req > pivotIdx)
            return quickSelect(nums, req, pivotIdx+1, right);
        else return nums[pivotIdx];
    }
    public int findKthLargest(int[] nums, int k) {
        // Use Quick Select algorithm for O(n) average time complexity
        // take a pivot, and assume that all numbers on the left are smaller than it and all numbers on the right are bigger than it
        // if that pivot index is n-k, then that is the k-th largest element
        int n = nums.length;
        int req = n-k;
        return quickSelect(nums, req, 0, n-1);
    }
}