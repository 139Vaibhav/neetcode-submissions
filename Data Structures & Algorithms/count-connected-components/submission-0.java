class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        for(int[] i : edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }

        boolean vis[] = new boolean[n];
        int cnt=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(adj, vis, i);
                cnt++;
            }
        }
        return cnt;
    }
    void dfs(List<List<Integer>> adj, boolean[] vis, int src){
        vis[src]=true;
        for(int neighbor : adj.get(src)){
            if(!vis[neighbor]){
                dfs(adj, vis, neighbor);
            }
        }
        return;
    }
}
