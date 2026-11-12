class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // Brute force - after adding each edge check if a cycle is formed
        int[] ans = new int[2];
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        for(int i=0;i<=n;i++)
            adj.add(new ArrayList<>());
        
        for(int[] i : edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
            boolean vis[] = new boolean[n+1];
            if(isCycle(adj, vis, i[0], -1)){
                ans[0]=i[0];
                ans[1]=i[1];
                break;
            }
        }
        return ans;
    }
    boolean isCycle(List<List<Integer>> adj, boolean[] vis, int src, int parent){
        vis[src]=true;
        for(int neighbor : adj.get(src)){
            if(!vis[neighbor]){
                if(isCycle(adj, vis, neighbor, src)) return true;
            } else if(parent!=neighbor) return true;
        }
        return false;
    }
}
