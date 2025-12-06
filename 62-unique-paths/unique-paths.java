class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        for(int r[] : dp){
            Arrays.fill(r , -1);
        }
        return solve(0,0,m,n,dp);
    }
    public int solve(int row , int col , int m , int n,int[][]dp){
        if(row >= m || col >= n){
            return 0;
        }
        if(row == m-1 && col == n-1){
            return 1;
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        dp[row][col] = solve(row+1,col,m,n,dp) + solve(row,col+1,m,n,dp);
        return dp[row][col];
    }
}