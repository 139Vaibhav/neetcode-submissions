class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<prerequisites.length;i++)
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);

        // BFS Approach - Kahn's algorithm
        Queue<Integer> q = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int neighbor : adj.get(i)){
                inDegree[neighbor]++;
            }
        }
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0)
                q.add(i);
        }
        int count=0;
        while(!q.isEmpty()){
            int src = q.poll();
            count++;
            for(int neighbor : adj.get(src)){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0)
                    q.add(neighbor);
            }
        }
        return count==numCourses;
    }
}
