class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int vis[] = new int[numCourses];
        int pathvis[] = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i<numCourses ; i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[] :prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
        }

        for(int i=0 ; i<numCourses ; i++){
            if(vis[i] == 0){
                if(dfs(i , vis,adj,pathvis) == true){
                    return false;
                }
            }
        }
        return true;
        
    }
    public boolean dfs(int node,int[]vis ,ArrayList<ArrayList<Integer>> adj,int[]pathvis){
        vis[node] = 1;
        pathvis[node] = 1;

        for(int neigh : adj.get(node)){
            if(vis[neigh] == 0){
                if(dfs(neigh,vis,adj,pathvis)==true){
                    return true;
                }
            }
            else if(pathvis[neigh] == 1){
                return true;
            }
        }
        pathvis[node] = 0;
        return false;
    }
}