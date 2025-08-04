
class Solution {
    class Pair{
        int v;
        int w;
        Pair(int v , int w){
            this.v = v;
            this.w = w;
        }
    }
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        int[]vis = new int[adj.size()];
        int[] dist = new int[adj.size()];
        for(int i=0 ; i<adj.size() ; i++){
            dist[i] = (int)1e9;
        }
        vis[src] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        dist[src] = 0;
        while(!q.isEmpty()){
            Pair p = q.remove();
            if(dist[p.v] != (int)1e9){
                for(int neigh : adj.get(p.v)){
                    if(dist[p.v] + 1 < dist[neigh]){
                        dist[neigh] = dist[p.v] + 1;
                        q.add(new Pair(neigh ,dist[p.v] + 1));
                    }
                }
            }
            
        }
        for(int i=0; i<adj.size() ; i++){
            if(dist[i] == (int)1e9){
                dist[i] = -1;
            }
        }
        return dist;
        
    }
}
