class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] vis = new int[adj.size()];
        ArrayList<Integer> ls = new ArrayList<>();
        
        for(int i=0 ; i<adj.size() ; i++){
            if(vis[i] == 0){
                dfs(i,vis,ls,adj);
            }
        }
        return ls;
        
    }
    public void dfs(int curr , int[]vis , ArrayList<Integer> ls ,ArrayList<ArrayList<Integer>> adj){
        vis[curr] = 1;
        ls.add(curr);
        for(int neigh : adj.get(curr)){
            if(vis[neigh] == 0){
                dfs(neigh , vis , ls , adj);
            }
        }
    }
}