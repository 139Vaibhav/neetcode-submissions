class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map<String, List<Integer>> -> {{"act":[0,3]}, {"opst":[1,2,4]}}
        // TC - O(n^2log(n)), SC - O(n)
        Map<String, List<Integer>> mp = new HashMap<>();
        int n = strs.length;
        for(int i=0;i<n;i++){
            char arr[] = strs[i].toCharArray();
            Arrays.sort(arr);
            String temp = new String(arr);
            mp.computeIfAbsent(temp, k->new ArrayList<>()).add(i);
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<Integer> l : mp.values()){
            List<String> temp = new ArrayList<>();
            for(int i=0;i<l.size();i++){
                temp.add(strs[l.get(i)]);
            }
            ans.add(temp);
        }
        return ans;
    }
}
