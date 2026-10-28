class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<List<Integer>> l = new ArrayList<>();
        int n = position.length;
        
        for (int i = 0; i < n; i++) {
            l.add(new ArrayList<>(List.of(position[i], speed[i])));
        }
        
        // Sort by position in descending order (closest to target first)
        Collections.sort(l, (a, b) -> Integer.compare(b.get(0), a.get(0)));

        Stack<Double> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            double time = (double) (target - l.get(i).get(0)) / l.get(i).get(1);
            
            // Only push if it's the first car or takes strictly more time
            if (st.isEmpty() || time > st.peek()) {
                st.push(time);
            }
        } // <-- The loop ends here now
        
        return st.size(); // <-- Moved outside the loop so it returns the final answer
    }
}
