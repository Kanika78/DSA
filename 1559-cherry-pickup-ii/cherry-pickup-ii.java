class Solution {
    public int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][][] dp = new int[r][c][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0 ,0,c-1,grid,dp);
        
    }
    public int solve(int i,int j1,int j2,int[][]grid,int[][][]dp){
        if(j1<0 || j1>=grid[0].length || j2<0 || j2>=grid[0].length){
            return (int)-1e8;
        }
        if(i == grid.length-1){
            //both reach same dest it will counted once
            if(j1==j2){
                return grid[i][j1];
            }else{
                return grid[i][j1] + grid[i][j2];
            }
        }
        if(dp[i][j1][j2] != -1){
            return dp[i][j1][j2];
        }
        //explore all paths -> for 1 movement of robo1, robo2 can move 3 diff movements
        int maxi = (int)-1e8;
        for(int dj1 = -1 ; dj1 <=1 ; dj1++){
            for(int dj2 = -1 ; dj2 <=1 ; dj2++){
                int val = 0;
                if(j1 == j2){
                    val = grid[i][j1];
                }else{
                    val = grid[i][j1]+grid[i][j2];
                }
                val += solve(i+1, dj1+j1, dj2+j2,grid,dp);
                maxi = Math.max(maxi , val);
            }
        }
        return dp[i][j1][j2] = maxi;

    }
}