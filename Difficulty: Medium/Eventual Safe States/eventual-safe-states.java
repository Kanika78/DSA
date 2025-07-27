// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        boolean[] vis = new boolean[V];
        boolean[] pathvis = new boolean[V];
        List<Integer> list = new ArrayList<>();
        
        for(int i=0 ; i< V; i++){
            if(!vis[i]){
                if(dfs(i , vis,pathvis,adj)== false){
                    list.add(i);
                }
            }else if(!pathvis[i]){
                list.add(i);
            }
        }
        return list;
        
    }
    public  boolean dfs(int node,boolean[]vis, boolean[]pathvis ,List<List<Integer>> adj){
        vis[node] = true;
        pathvis[node] = true;
        
        for(int neigh : adj.get(node)){
            if(!vis[neigh]){
                if(dfs(neigh,vis,pathvis,adj)==true){
                    return true;
                }
            }
            else if(pathvis[neigh]){
                return true;
            }
        }
        pathvis[node] = false;
        return false;
    }
}
