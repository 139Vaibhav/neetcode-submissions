class Solution {
    public boolean isAnagram(String s, String t) {
        // sort them both -> TC - O(nlogn), SC - O(1)
        // hashmap -> TC - O(n), SC - O(n)
        Map<Character,Integer> mp = new HashMap<>();
        int n1= s.length();
        for(int i=0;i<n1;i++){
            char c = s.charAt(i);
            mp.put(c, mp.getOrDefault(c, 0)+1);
        }
        int n2 = t.length();
        for(int i=0;i<n2;i++){
            char c = t.charAt(i);
            if(!mp.containsKey(c))
                return false;
            else{
                mp.put(c, mp.get(c)-1);
                if(mp.get(c)==0)
                    mp.remove(c);
            }
        }
        if(mp.size()==0)
            return true;
        return false;
    }
}
