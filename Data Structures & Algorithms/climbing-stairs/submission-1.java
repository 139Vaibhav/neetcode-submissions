class Solution {
    int ans[];
    int rec(int idx, int n){
        if(idx>=n) return 1;
        if(ans[idx]!=-1) return ans[idx];
        ans[idx] = rec(idx+1, n) + rec(idx+2, n);
        return ans[idx];
    }
    public int climbStairs(int n) {
        // 2 options at any given index
        // 1 step or 2 step
        // explore both paths
        ans=new int[n];
        Arrays.fill(ans, -1);
        return rec(1, n);
    }
}
