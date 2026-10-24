class Solution {
    public int maxArea(int[] heights) {
        // brute force - O(n^2)
        int n = heights.length;
        int maxArea = 0;
        int left=0, right=n-1;
        while(left<right){
            maxArea = Math.max(maxArea, (right-left)*Math.min(heights[left], heights[right]));
            if(heights[left]<heights[right]) left++;
            else if(heights[right]<heights[left]) right--;
            else{
                left++;
                right--;
            }
        }
        return maxArea;
    }
}
