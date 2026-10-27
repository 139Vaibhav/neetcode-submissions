class MinStack {
    class MS{
        int x;
        int mv;
        MS(int x, int mv){
            this.x=x;
            this.mv=mv;
        }
    }
    Stack<MS> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty())
            st.push(new MS(val, val));
        else
            st.push(new MS(val, Math.min(st.peek().mv, val)));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().x;
    }
    
    public int getMin() {
        return st.peek().mv;
    }
}
