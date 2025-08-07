class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] mat = new int[n][n];
        for(int r[] : mat){
            Arrays.fill(r , 10001);
        }
        for(int[]edge : edges){
            int u= edge[0];
            int v = edge[1];
            int w = edge[2];
            mat[u][v] = w;
            mat[v][u] = w;
        }
        for(int i=0 ; i<n ; i++){
            mat[i][i] = 0;
        }
        
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    mat[i][j] = Math.min(mat[i][j], 
                    mat[i][k]+mat[k][j]);
                }
            }
        }

        int Cntcity = n;
        int cityNo = 0;
        for(int city = 0 ; city < n ; city++){
            int cnt = 0;
            for(int adj = 0 ; adj<n ;adj ++){
                if(mat[city][adj] <= distanceThreshold){
                    ++cnt;
                }
            }
            if(cnt <= Cntcity){
                Cntcity = cnt;
                cityNo = city;
            }
        }
        return cityNo;
        
    }
}