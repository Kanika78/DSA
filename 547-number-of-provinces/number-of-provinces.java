class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int vis[] = new int[isConnected.length];
        for(int i=0 ; i<isConnected.length; i++){
            if(vis[i] == 0){
                count++;
            }
            dfs(i , vis,isConnected);
        }
        return count;   
    }
    public void dfs(int curr,int[]vis,int[][] isConnected){
        vis[curr] = 1;
        for(int i=0 ; i<isConnected.length ; i++){
            if(vis[i] == 0 && isConnected[curr][i] ==1){
                dfs(i,vis,isConnected);
            }
        }
    }
}