class Solution {
    Set<String> st;
    int[] dp;

    boolean rec(int idx, String s){
        if(idx==s.length()){
            dp[idx]=1;
            return true;
        }
        if(dp[idx]!=-1){
            if(dp[idx]==1) return true;
            else {
                dp[idx]=0;
                return false;
            }
        }

        for(int i=idx+1;i<=s.length();i++){
            String t = s.substring(idx,i);
            if(st.contains(t)){
                if(rec(i,s)){
                    dp[idx]=1;
                    return true;
                }
            }
        }
        dp[idx]=0;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        // "catsincars"
        // "c", "ca", "cat" - rec(sincars), "cats" - rec(incars), 
        st = new HashSet<>();
        for(String x : wordDict){
            st.add(x);
        }
        dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        // 0 -> visited but false
        // -1 -> unvisited
        // 1 -> visited and true
        return rec(0,s);
    }
}
