class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // [30,38,30,36,35,40,28]
        // brute force - O(n^2)
        int n = temperatures.length;
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(temperatures[j]>temperatures[i]){
                    ans[i]=j-i;
                    break;
                }
            }
        }
        return ans;
    }
}
