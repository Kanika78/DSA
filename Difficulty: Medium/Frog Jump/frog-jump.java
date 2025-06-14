// User function Template for Java
class Solution {
    int minCost(int[] height) {
        // code here
        int dp[] = new int[height.length+1];
        Arrays.fill(dp , -1);
        return solve(0 , height , dp);
    }
    public int solve(int indx , int height[] , int[]dp){
        if(indx == height.length-1){
            return 0;
        }
        if(dp[indx] != -1){
            return dp[indx];
        }
        int jump1 = Math.abs(height[indx] - height[indx+1]) + solve(indx+1,height,dp) ;
        int jump2 = Integer.MAX_VALUE;
        if(indx < height.length-2){
            jump2 = Math.abs(height[indx] - height[indx+2]) + solve(indx+2 , height,dp);
        }
        return dp[indx] = Math.min(jump1 , jump2);
    }
}