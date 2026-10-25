class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0) return 0;
        int i=0, j=1;
        Set<Character> st = new HashSet();
        st.add(s.charAt(0));
        int maxlen=1;
        while(j<n){
            while(st.contains(s.charAt(j))){
                st.remove(s.charAt(i));
                i++;    
            }
            st.add(s.charAt(j));
            maxlen = Math.max(maxlen, j-i+1);
            j++;
        }
        return maxlen;
    }
}
