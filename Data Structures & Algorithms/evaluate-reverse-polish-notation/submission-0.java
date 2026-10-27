class Solution {
    public int evalRPN(String[] tokens) {
        // ["1","2","+","3","*","4","-"]
        Stack<String> st = new Stack<>();
        int n = tokens.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            String symbol = tokens[i];
            if(!st.isEmpty() && (symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/"))){
                int y = Integer.parseInt(st.pop());
                int x = Integer.parseInt(st.pop());
                if(symbol.equals("+"))
                    st.push(String.valueOf(x+y));
                else if(symbol.equals("-"))
                    st.push(String.valueOf(x-y));
                else if(symbol.equals("*"))
                    st.push(String.valueOf(x*y));
                else
                    st.push(String.valueOf(x/y));
            } else{
                st.push(symbol);
            }
        }
        return Integer.parseInt(st.peek());
    }
}
