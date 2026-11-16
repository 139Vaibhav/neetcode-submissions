class Solution {
    int dp[][];
    boolean rec(int idx, int n, int newSum, int oldSum, int[] nums){
        // System.out.println("idx="+idx);
        // System.out.println("oldSum="+oldSum+" newSum="+newSum);
        if(newSum==oldSum){
            dp[idx][newSum]=1;
            return true;
        }
            
        
        if(idx>=n){
            dp[idx][newSum]=0;
            return false;
        }
        
        if(dp[idx][newSum]!=-1){
            if(dp[idx][newSum]==0) return false;
            else return true;
        }
        // take
        boolean take = rec(idx+1,n,newSum+nums[idx],oldSum-nums[idx],nums);

        // not take
        boolean nottake = rec(idx+1,n,newSum,oldSum,nums);
        if(take || nottake){
            dp[idx][newSum]=1;
            return true;
        } else{
            dp[idx][newSum]=0;
            return false;
        }
    }
    public boolean canPartition(int[] nums) {
        // [1,2,3,4]
        // oldsum=sum(all)=10
        // newsum -> 2 states, take or not take
        
        int n = nums.length;
        int sum=0;
        for(int x : nums)
            sum+=x;
        dp = new int[n+1][sum+1];
        for(int[] x : dp)
            Arrays.fill(x,-1);
        return rec(0,n,0,sum,nums);
        
    }
}
