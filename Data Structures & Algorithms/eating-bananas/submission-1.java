class Solution {
    long check(int x, int[] piles){
        int n = piles.length;
        long sum=0;
        for(int i=0;i<n;i++){
            sum+= piles[i]/x;
            if(piles[i]%x!=0)
                sum++;
        }
        return sum;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int lo=1;
        int hi=0;
        int n = piles.length;
        for(int i=0;i<n;i++)
            hi = Math.max(hi, piles[i]);
        int minHour = Integer.MAX_VALUE;
        int ans=-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(check(mid, piles)<=h){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
}
