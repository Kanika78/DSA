class Solution {
    public int makeConnected(int n, int[][] connections) {
        int[] par = new int[n];
        int[] rank = new int[n];
        for(int i=0 ; i<n ; i++){
            rank[i] = 0;
            par[i] = i;
        }
        int edges = 0;
        for(int edge[] : connections){
            int u = edge[0];
            int v = edge[1];
            if(!UnionRank(u , v, par,rank)){
                edges++;
            } 
        }
        int noOfComponent = 0;
        for(int i=0 ; i< n ; i++){
            if(findPar(i, par)== i){
                noOfComponent++;
            }
        }
        return edges >= noOfComponent-1 ? noOfComponent-1 : -1; 

        
    }
    public int findPar(int u , int[]par){
        if(u == par[u]){
            return u;
        }
        return par[u] = findPar(par[u] , par);
    }
    public boolean UnionRank(int u , int v , int par[] , int rank[]){
        int ulp_u = findPar(u,par);
        int ulp_v = findPar(v,par);
        if(ulp_u == ulp_v){
            return false;
        }
        if(rank[ulp_u] < rank[ulp_v]){
            par[ulp_u] = par[ulp_v];
            return true;
        }
        else if(rank[ulp_u] > rank[ulp_v]){
            par[ulp_v] = par[ulp_u];
            return true;
        }else{
            par[ulp_v] = par[ulp_u];
            int rankU = rank[ulp_u];
            rank[ulp_v] = rankU+1;
            return true;

        }
    }

}