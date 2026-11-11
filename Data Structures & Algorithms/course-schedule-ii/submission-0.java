class Solution {
    Stack<Integer> st;
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
        st.push(src);
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create the Graph
        st = new Stack<>();
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<prerequisites.length;i++)
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        
        //DFS Approach
        int ans[] = new int[numCourses];
        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(isCycleDFS(adj,i,vis,pathVis))
                    return new int[0];
            }
        }
        int idx=0;
        while(!st.isEmpty()){
            ans[idx++]=st.pop();
        }
        return ans;
    }
}
