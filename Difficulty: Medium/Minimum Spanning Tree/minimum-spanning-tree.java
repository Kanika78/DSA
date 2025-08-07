class Solution {
    class Pair{
        int v;
        int w;
        Pair(int v , int w){
            this.v = v;
            this.w = w;
        }
    }
    class pair{
        int node;
        int parent;
        int wt;
        pair(int node , int parent , int wt){
            this.node = node;
            this.parent = parent;
            this.wt = wt;
        }
    }
    public int spanningTree(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0 ; i<V ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[]edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        int sum = 0;
        PriorityQueue<pair> pq = new PriorityQueue<>((x,y)-> x.wt - y.wt);
        pq.add(new pair(0,-1,0));
        int[] vis = new int[V];
        
        while(!pq.isEmpty()){
            pair p = pq.remove();
            int node = p.node;
            int parent = p.parent;
            int wt = p.wt;
            if(vis[node] == 0){
                sum += wt;
                vis[node] = 1;
            }
            for(Pair neighs : adj.get(node)){
                int neigh = neighs.v;
                int weight = neighs.w;
                if(vis[neigh] == 0){
                    pq.add(new pair(neigh , node,weight));
                }
                
            }
        }
        return sum;
    }
}
