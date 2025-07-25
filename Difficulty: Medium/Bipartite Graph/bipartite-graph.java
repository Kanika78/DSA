class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        int vis[] = new int[V];
        Arrays.fill(vis,-1);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i<V ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[]edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return bfs(0,adj,vis);
    }
    public boolean bfs(int node,ArrayList<ArrayList<Integer>> adj,int[]vis){
        vis[node] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()){
            int val = q.remove();
            for(int neigh : adj.get(val)){
                if(vis[neigh] == -1){
                    if(vis[val] == 0){
                        vis[neigh] = 1;
                    }else{
                        vis[neigh] = 0;
                    }
                    q.add(neigh);
                }else{
                    if(vis[neigh] == vis[val]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}