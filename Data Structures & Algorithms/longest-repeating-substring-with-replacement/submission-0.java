class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if(n==1) return 1;
        Map<Character,Integer> mp = new HashMap<>();
        int l=0, r=0, maxf=0;
        int ans=0;
        while(r < n){
            mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, mp.get(s.charAt(r)));
            while(r-l+1 - maxf > k){
                mp.put(s.charAt(l), mp.get(s.charAt(l))-1);
                l++;
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}
/*
aabbaabbbd
mp = [a->2, b->5, d->1]
maxF=5
res=7;
l=2,r=8
*/