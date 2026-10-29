class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] right = new int[n];
        int[] left = new int[n];
        for(int i=0;i<n;i++){
            left[i]=-1;
            right[i]=n;
        }
        Stack<Integer> s1 = new Stack<>();
        for(int i=0;i<n;i++){
            while(!s1.isEmpty() && heights[s1.peek()]>heights[i]){
                right[s1.peek()]=i;
                s1.pop();
            }
            s1.push(i);
        }
        Stack<Integer> s2 = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!s2.isEmpty() && heights[s2.peek()]>heights[i]){
                left[s2.peek()]=i;
                s2.pop();
            }
            s2.push(i);
        }
        int maxArea=0;
        for(int i=0;i<n;i++){
            int width = (right[i]-left[i]-1);
            maxArea = Math.max(maxArea, width*heights[i]);
        }
        return maxArea;
    }
}
