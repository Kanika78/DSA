class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0 ; i<isConnected.length ;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<isConnected.length ; i++){
            for(int j=0; j<isConnected.length ; j++){
                if(i != j && isConnected[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int count = 0;
        int vis[] = new int[isConnected.length];
        for(int i=0 ; i<adj.size() ; i++){
            if(vis[i] == 0){
                count++;
            }
            dfs(i , vis,adj);
        }
        return count;   
    }
    public void dfs(int curr,int[]vis,ArrayList<ArrayList<Integer>> adj){
        vis[curr] = 1;
        for(int neigh : adj.get(curr)){
            if(vis[neigh] == 0){
                dfs(neigh,vis,adj);
            }
        }
    }
}