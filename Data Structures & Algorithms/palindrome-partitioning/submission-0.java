class Solution {
    List<List<String>> ans;
    boolean isPallindrome(String s){
        String temp = new StringBuilder(s).reverse().toString();
        if(temp.equals(s))
            return true;
        else
            return false;
    }
    void rec(int idx, List<String> l, String s){
        if(idx==s.length()){
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i=idx;i<s.length();i++){
            String temp = s.substring(idx,i+1);
            if(isPallindrome(temp)){
                l.add(temp);
                rec(i+1, l, s);
                l.removeLast();
            }
        }
    }
    public List<List<String>> partition(String s) {
        // "aab"
        // try to cut at every possible place
        // "aab" - cut at 0
        // "a" "ab" - not a pallindrome
        // "aa" "b" - it is a pallindrome
        ans = new ArrayList<>();
        rec(0, new ArrayList<>(), s);
        return ans;
    }
}
