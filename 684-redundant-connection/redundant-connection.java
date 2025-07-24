class Solution {
    class Pair{
        int node;
        int parent;
        Pair(int node,int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i<=edges.length;i++){
            adj.add(new ArrayList<>());
        }
    
        for(int[]edge:edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

            int vis[] = new int[adj.size()];
            if(bfs(u , vis,adj)){
                return edge;
            }
        }
        
        return new int[]{};


        
    }
    public boolean bfs(int node,int vis[],ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node,-1));
        while(!q.isEmpty()){
            Pair val = q.remove();
            int curr = val.node;
            int par = val.parent;
            for(int neigh : adj.get(curr)){
                if(vis[neigh]==0){
                    q.add(new Pair(neigh , curr));
                    vis[neigh] = 1;
                }
                else if(par != neigh){
                    return true;
                }
            }
        }
        return false;
    }
}