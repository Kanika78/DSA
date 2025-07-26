class Solution {
    public static ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i< n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[] : prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        boolean[] pathvis = new boolean[n];
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0 ; i< n ; i++){
            if(!vis[i]){
                if(dfs(i , vis,pathvis,adj,list)){
                    return new ArrayList<>();
                }
            }
        }
        Collections.reverse(list);
        return list;
    }
    public static boolean dfs(int node,boolean[]vis, boolean[]pathvis ,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> list){
        vis[node] = true;
        pathvis[node] = true;
        
        for(int neigh : adj.get(node)){
            if(!vis[neigh]){
                if(dfs(neigh,vis,pathvis,adj,list)==true){
                    return true;
                }
            }
            else if(pathvis[neigh]){
                return true;
            }
        }
        pathvis[node] = false;
        list.add(node);
        return false;
    }
}