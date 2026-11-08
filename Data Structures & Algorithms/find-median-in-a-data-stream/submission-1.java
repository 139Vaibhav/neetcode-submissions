class MedianFinder {
    // Think of 2 priority queues
    // 1st one has the smallest half, 2nd one has the biggest half
    // 1,3,5,1,6,2,7
    // small - 1,3,1,2
    // large - 5,6,7

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (small.isEmpty() || num <= small.peek()) {
            small.add(num);
        } else {
            large.add(num);
        }

        if (small.size() > large.size() + 1) {
            large.add(small.poll());
        } 
        else if (large.size() > small.size()) {
            small.add(large.poll());
        }

    }
    
    public double findMedian() {
        if(small.size()==large.size()){
            return (small.peek()+large.peek())/2.0;
        }
        else{
            return small.peek();
        }
    }
}
