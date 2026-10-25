class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1>n2) return false;
        Map<Character, Integer> mp1 = new TreeMap<>();
        for(int i=0;i<n1;i++){
            mp1.put(s1.charAt(i), mp1.getOrDefault(s1.charAt(i), 0)+1);
        }
        
        int i=0, j=0;
        Map<Character, Integer> mp2 = new TreeMap<>();

        while(j<n2){
            mp2.put(s2.charAt(j), mp2.getOrDefault(s2.charAt(j),0)+1);
            while(j-i+1 > n1){
                mp2.put(s2.charAt(i), mp2.getOrDefault(s2.charAt(i),0)-1);
                if(mp2.get(s2.charAt(i))==0)
                    mp2.remove(s2.charAt(i));
                i++;
            }
            if(mp1.equals(mp2)) return true;
            j++;
        }
        return false;
    }
}
