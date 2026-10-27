class MinStack {
    PriorityQueue<Integer> pq;
    Stack<Integer> st;
    public MinStack() {
        pq = new PriorityQueue<>();
        st = new Stack<>();
    }
    
    public void push(int val) {
        pq.add(val);
        st.push(val);
    }
    
    public void pop() {
        int x = st.pop();
        pq.remove(x);
        return;
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        if(!pq.isEmpty())
            return pq.peek();
        else
            return -1;
    }
}
/*
[1,2,-2,-1,-2,3]
pop=[1,2,-2,-1,-2]
top = -2
getMin = -2
pop = [1,2,-2,-1]
getMin = -2
pop = [1,2,-2]
top = -2
getMin = -2
pop = [1,2]
top = 2
getMin = 1
pop
getMin
*/