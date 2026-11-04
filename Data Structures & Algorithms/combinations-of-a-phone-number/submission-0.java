class Solution {
    Map<Character, List<Character>> mp;
    List<String> ans;
    StringBuilder sb;
    void rec(int idx, String digits, StringBuilder sb){
        if(idx==digits.length()){
            ans.add(sb.toString());
            return;
        }
        
            List<Character> l = mp.get(digits.charAt(idx));
            for(Character c : l){
                sb.append(c);
                rec(idx+1, digits, sb);
                sb.setLength(sb.length()-1);
            }
        
    }
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        mp = new HashMap<>();
        sb = new StringBuilder();
        if (digits.isEmpty()) return new ArrayList<>();

        mp.put('2', List.of('a','b','c'));
        mp.put('3', List.of('d','e','f'));
        mp.put('4', List.of('g','h','i'));
        mp.put('5', List.of('j','k','l'));
        mp.put('6', List.of('m','n','o'));
        mp.put('7', List.of('p','q','r','s'));
        mp.put('8', List.of('t','u','v'));
        mp.put('9', List.of('w','x','y','z'));
        
        rec(0,digits,sb);
        return ans;
    }
}
