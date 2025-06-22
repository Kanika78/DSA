class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // 
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        for(int j =0 ; j<n; j++){
            dp[0][j] = matrix[0][j];
        }
        for(int i=1; i<m; i++){
            for(int j=0 ; j<n;j++){
                int up = dp[i - 1][j];
                int left = (j > 0) ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int right = (j < n - 1) ? dp[i - 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(left, right));

            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[m - 1][j]);
        }

        return min;
    }
    public int solve(int i , int j , int[][]grid , int[][]dp){
        if(j >= grid[0].length || j < 0){
            return (int)Math.pow(10 , 9);
        }
        if(i == grid.length-1){
            return grid[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int down = grid[i][j] + solve(i+1 , j , grid , dp);
        int rightDia = grid[i][j] + solve(i+1 , j+1, grid , dp);
        int leftDia = grid[i][j] + solve(i+1 , j-1, grid , dp);



        return dp[i][j] = Math.min(down, Math.min(leftDia, rightDia));
    }
}