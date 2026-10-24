class Solution {

    public String encode(List<String> strs) {
        // I will use "vbisbest" as the joining string
        // encoded = HellovbisbestWorldvbisbest
        StringBuilder sb = new StringBuilder();
        String fix = "vbisbest";
        int n = strs.size();
        for(int i=0;i<n;i++){
            sb.append(strs.get(i));
            sb.append(fix);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        if(str.length()==0)
            return ans;
        StringBuilder s = new StringBuilder();
        for(int i=0;i<str.length()-8;i++){
            String temp = str.substring(i,i+8);
            System.out.println(temp);
            if(temp.equals("vbisbest")){
                ans.add(s.toString());
                i=i+7;
                s = new StringBuilder();
            }
            else{
                s.append(str.charAt(i));
            }
        }
        ans.add(s.toString());
        return ans;
    }
}
