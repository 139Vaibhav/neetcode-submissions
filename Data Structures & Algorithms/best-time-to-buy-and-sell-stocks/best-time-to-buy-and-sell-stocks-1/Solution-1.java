class Solution {
    public int maxProfit(int[] prices) {
        // TC -> O(n^2)
        // int ans=0;
        // int n = prices.length;
        // for(int i=0;i<n;i++){
        //     for(int j=i;j<n;j++){
        //         ans = Math.max(ans, prices[j]-prices[i]);
        //     }
        // }
        // return ans;
        int ans=0;
        int n = prices.length;
        // smallest num from left
        // biggest num from right
        // [7,1,1,1,1,1]
        // [7,6,6,6,6,4]
        // instead of an array, I can have 2 variables
        int[] minLeft=new int[n];
        int[] maxRight=new int[n];
        minLeft[0]=prices[0];
        maxRight[n-1]=prices[n-1];
        for(int i=1;i<n;i++){
            minLeft[i]=Math.min(minLeft[i-1], prices[i]);
        }
        for(int i=n-2;i>=0;i--){
            maxRight[i]=Math.max(maxRight[i+1], prices[i]);
        }
        for(int i=0;i<n;i++)
            ans = Math.max(ans, maxRight[i]-minLeft[i]);
        return ans;
    }
}