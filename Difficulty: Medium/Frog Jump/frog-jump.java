class Solution {
    int minCost(int[] height) {
        // code here
        int dp[] = new int[height.length];
        Arrays.fill(dp, -1);
        return solve(height.length-1 ,height , dp);
    }
    public int solve(int indx , int[]height , int[]dp){
        if(indx == 0){
            return 0;
        }
        if(dp[indx] != -1){
            return dp[indx];
        }
        int left = solve(indx - 1, height , dp) + Math.abs(height[indx] - height[indx-1]);
        int right = Integer.MAX_VALUE;
        if(indx > 1){
            right = solve(indx-2, height , dp) + Math.abs(height[indx] - height[indx-2]);
        }
        
        return dp[indx] = Math.min(left , right);
    }
}