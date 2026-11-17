class Solution {
    public int maxProfit(int[] prices) {
        // Use monotonic stack
        Stack<Integer> st = new Stack<>();
        int n = prices.length;
        int ans=0;
        st.push(prices[0]);
        for(int i=1;i<n;i++){
            if(!st.isEmpty() && st.peek() < prices[i]){
                ans+=(prices[i]-st.pop());
            }
           st.push(prices[i]);
        }
        return ans;
    }
}