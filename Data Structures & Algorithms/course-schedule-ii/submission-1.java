class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create the Graph
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<prerequisites.length;i++)
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);

        // Kahn'a algorithm
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int neighbor : adj.get(i))
                indegree[neighbor]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        int ans[] = new int[numCourses];
        int idx=0;
        int count=0;
        while(!q.isEmpty()){
            count++;
            int src = q.poll();
            ans[idx++]=src;
            for(int neighbor : adj.get(src)){
                indegree[neighbor]--;
                if(indegree[neighbor]==0) q.add(neighbor);
            }
        }
        if(count!=numCourses) return new int[0];
        else return ans;
    }
}
