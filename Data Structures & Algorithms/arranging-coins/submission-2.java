class Solution {
    public int arrangeCoins(int n) {
        // S = n*(n+1)/2
        // n=3, S=6
        // n=4, S=10 > 9
        // Algorithm -> x*(x+1) < 2n
        int ans=1;
        for(long i=1;i<=n/2;i++){
            if((i*(i+1))/2 < (n))
                ans = (int)i;
            else break;
        }
        return ans;
    }
}