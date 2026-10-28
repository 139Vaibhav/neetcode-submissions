class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // [30,38,30,36,35,40,28]
        // [{30,0}]
        // [38] ans=[1]
        // [38,30] ans=[1,0]
        // [38,36] ans=[1,0,1]
        // [38,36,35] ans=[1,0,1,0]
        // 
        Stack<int[]> st = new Stack<>();
        int n = temperatures.length;
        int ans[] = new int[n];
        st.push(new int[]{temperatures[0],0});
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && temperatures[i]>st.peek()[0]){
                ans[st.peek()[1]]=i-st.peek()[1];
                st.pop();
            }
            st.push(new int[]{temperatures[i],i});
        }
        return ans;
    }
}
