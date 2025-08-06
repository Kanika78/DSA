class Solution {
    class Pair{
        int v;
        int wt;
        Pair(int v , int wt){
            this.v = v;
            this.wt = wt;
        }
    }
    public int findDelayTime(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0 ; i<V ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[]edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(v ,w));
        }
        int[]dist = new int[V];
        Arrays.fill(dist , (int)1e9);
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> x.wt - y.wt);
        dist[src] = 0;
        pq.add(new Pair(src ,0));

        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int node = p.v;
            int wt = p.wt;
            for(Pair neighs : adj.get(node)){
                int neigh = neighs.v;
                int weight = neighs.wt;
                if(wt + weight < dist[neigh]){
                    dist[neigh] = wt + weight;
                    pq.add(new Pair(neigh , dist[neigh]));
                }
            }
        }
        int max = 0;
        for(int i=0 ; i<V ; i++){
            if(dist[i] == (int)1e9){
                return -1;
            }
            max = Math.max(max , dist[i]);
        }
        return max;
    }
}