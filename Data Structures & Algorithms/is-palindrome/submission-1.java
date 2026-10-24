class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb1 = new StringBuilder();
        int n = s.length();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if((c >= 'a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9'))
                sb1.append(Character.toLowerCase(s.charAt(i)));
        }
        StringBuilder sb2 = new StringBuilder(sb1).reverse();
        System.out.println(sb1);
        System.out.println(sb2);
        if(sb1.toString().equals(sb2.toString()))
            return true;
        else
            return false;
    }
}
