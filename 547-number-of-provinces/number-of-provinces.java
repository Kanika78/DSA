class Solution {
    public int findCircleNum(int[][] isConnected) {
        int rank[] = new int[isConnected.length];
        int parent[] = new int[isConnected.length];

        for(int i=0 ; i<parent.length ; i++){
            parent[i] = i;
        }
        for(int i=0 ; i<isConnected.length ;i++){
            for(int j=i+1 ; j<isConnected.length ; j++){
                if(isConnected[i][j] == 1){
                    union(i , j , parent, rank);
                }
            }
        }
        int comp = 0;
        for(int i=0 ; i<parent.length ; i++){
            if(parent[i] == i){
                comp++;
            }
        }
        return comp;
    }
    public boolean union(int u , int y, int[]parent, int[]rank){
        int parent_u = find(u , parent);
        int parent_y = find(y , parent);

        if(parent_u == parent_y){
            return false;
        }
        if(rank[parent_u] < rank[parent_y]){
            parent[parent_u] = parent_y;
        }
        else if(rank[parent_u] > rank[parent_y]){
            parent[parent_y] = parent_u;
        }else{
            parent[parent_u] = parent_y;
            rank[parent_y]++;
        }
        return true;
    }
    public int find(int u, int[] parent) {
        if (parent[u] != u) {
            parent[u] = find(parent[u], parent);  
        }
        return parent[u];
    }

}