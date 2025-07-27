class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i<V ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        for(int i=0 ; i<V ; i++){
            if(!vis[i]){
                dfs(i,vis,adj,st);
            }
        }
        ArrayList<Integer> ls = new ArrayList<>();
        while(!st.isEmpty()){
            ls.add(st.pop());
        }
        return ls;
    }
    public static void dfs(int node,boolean[]vis ,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st){
        vis[node] = true;
        for(int neigh : adj.get(node)){
            if(!vis[neigh]){
                dfs(neigh , vis,adj,st);
            }
        }
        st.push(node);
    }
    
}