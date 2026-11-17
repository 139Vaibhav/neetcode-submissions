class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy=prices[0];
        int ans=0;
        for(int x : prices){
            if(x<buy)
                buy=x;
            ans = Math.max(ans, x-buy);
        }
        return ans;
    }
}