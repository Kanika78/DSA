class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(triangle.size() <= 0){
            return 0;
        }
        // int ans = solve(0 , 0 , triangle);
        int dp[][] = new int[n][n];
        for(int i=0; i<n ; i++){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }

        for(int i=n-2 ; i>=0 ; i--){
            for(int j=i ; j>=0 ; j--){
                dp[i][j] = triangle.get(i).get(j)+Math.min(dp[i+1][j] , dp[i+1][j+1]);
            }
        }
        return dp[0][0];
        
        
    }
    public int solve(int indx,int li,List<List<Integer>> triangle){
        if(li == triangle.size()-1){
            return triangle.get(li).get(indx); 
        }
        int take = solve(indx , li+1,triangle);
        int notTake = solve(indx+1 , li+1,triangle);

        return triangle.get(li).get(indx)+Math.min(take , notTake);

    }
}