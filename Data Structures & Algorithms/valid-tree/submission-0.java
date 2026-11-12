class Solution {
    public boolean validTree(int n, int[][] edges) {
        // valid tree means no cycles and no disconnected graphs
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int[] i : edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }

        int cnt = 0;
        boolean vis[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(isCycleDFS(adj, vis, i, -1)) return false;
                cnt++;
            }
        }
        // System.out.println("cnt="+cnt);
        if(cnt>1) return false;
        else return true;
    }
    boolean isCycleDFS(List<List<Integer>> adj, boolean[] vis, int src, int parent){
        vis[src]=true;
        for(int neighbor : adj.get(src)){
            if(!vis[neighbor]){
                 if(isCycleDFS(adj, vis, neighbor, src)) return true;
            }
            else if(parent!=neighbor) return true;
        }
        return false;
    }
}
