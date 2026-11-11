class Solution {
    boolean isCycleDFS(List<List<Integer>> adj, int src, boolean[] vis, boolean pathVis[]){
        vis[src]=true;
        pathVis[src]=true;

        for(int neighbor : adj.get(src)){
            if(!vis[neighbor]){
                if(isCycleDFS(adj,neighbor,vis,pathVis)) return true;
            }
            else if(pathVis[neighbor]) return true;
        }
        pathVis[src]=false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create the Graph
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<prerequisites.length;i++)
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        
        //DFS Approach
        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(isCycleDFS(adj,i,vis,pathVis))
                    return false;
            }
        }
        return true;
    }
}
