// User function Template for Java
class Solution {
    class Pair{
        int edge;
        int wt;
        Pair(int edge , int wt){
            this.edge = edge;
            this.wt = wt;
        }
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
                adj.add(new ArrayList<>()); 
        }

        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Pair(v,wt));
        }
        Stack<Integer> st = new Stack<>();
        int[] vis = new int[V];
        for(int i=0 ; i<V;i++){
            if(vis[i] == 0){
                topoSort(i,adj,st,vis);
            }
        } 
        
        int dist[] = new int[V];
        for(int i=0 ; i<V ; i++){
            dist[i] = (int)(1e9);
        }
        
        dist[0] = 0;
        while(!st.isEmpty()){
            int val = st.pop();
            if(dist[val] != (int)1e9){ 
                for(Pair p : adj.get(val)){
                    int v = p.edge;
                    int w = p.wt;
                    if(dist[val] + w < dist[v]){
                        dist[v] = dist[val] + w;
                    }
                    
                }
            }
        }
        for (int i = 0; i < V; i++) {
            if (dist[i] == (int)1e9) {
                dist[i] = -1;
            }
        }
        return dist;
        
    }
    public void topoSort(int node,ArrayList<ArrayList<Pair>> adj,Stack<Integer> st,int[]vis){
        vis[node] = 1;
        for(Pair p : adj.get(node)){
            if(vis[p.edge] == 0){
                topoSort(p.edge,adj,st,vis);
            }
        }
        st.push(node);
        
    }
}