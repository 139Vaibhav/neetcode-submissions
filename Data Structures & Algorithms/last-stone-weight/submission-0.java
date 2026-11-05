class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : stones)
            pq.add(x);
        while(pq.size()>=2){
            int x = pq.poll();
            int y = pq.poll();
            if(x==y) continue;
            else{
                pq.add(Math.abs(x-y));
            }
        }
        if(pq.size()!=0) return pq.peek();
        else return 0;
    }
}
