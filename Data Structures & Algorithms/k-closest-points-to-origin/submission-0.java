class Solution {
    class Pair{
        int dist;
        int x;
        int y;
        Pair(int dist, int x, int y){
            this.dist = dist;
            this.x = x;
            this.y = y;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.dist, b.dist));
        for(int i=0;i<points.length;i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            int d = (x1*x1 + y1*y1);
            pq.add(new Pair(d,x1,y1));
        }
        int[][] ans = new int [k][2];
        int i=0;
        while(!pq.isEmpty() && i<k){
            Pair t = pq.poll();
            ans[i][0]=t.x;
            ans[i][1]=t.y;
            i++;
        }
        return ans;
    }
}
