class Solution {
    public int maxProfit(int[] prices) {
        // TC - O(n), SC - O(1)
        // use sliding window
        // i, j=i+1, keep on increasing j as long as prices[j] is increasing
        // once it start decreasing then change i to j and j=i+1
        // Dry run - [10,1,5,6,7,1]
        // i=10, j=1
        // i=1, j=5,6,7
        int n = prices.length;
        int i=0, j=1;
        int maxProfit=0;
        while(j<n){
            if(prices[j]>prices[i]){
                maxProfit = Math.max(maxProfit, prices[j]-prices[i]);
            } else{
                i=j;
            }
            j++;
        }
        return maxProfit;
    }
}
