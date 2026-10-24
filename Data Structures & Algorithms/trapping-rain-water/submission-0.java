class Solution {
    public int trap(int[] height) {
        // [0,2,0,3,1,0,1,3,2,1]
        // [2,0,3] - (j-i-1)*minHeight
        // left  [0,2,2,3,3,3,3,3,3,3]
        // right [3,3,3,3,3,3,3,3,2,1]
        //       [0,2,0,3,1,0,1,3,2,1]
        //.       0,0,2,0,2,3,2,0,0,0
        int n = height.length;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0]=height[0];
        right[n-1]=height[n-1];
        for(int i=1;i<n;i++){
            left[i] = Math.max(left[i-1], height[i]);
        }
        
        for(int i=n-1;i>0;i--){
            right[i-1]=Math.max(height[i-1], right[i]);
        }

        int sum=0;
        for(int i=0;i<n;i++){
            sum+= Math.abs(Math.min(left[i], right[i])-height[i]);
        }
        return sum;
    }
}
