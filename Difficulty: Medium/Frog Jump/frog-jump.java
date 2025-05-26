// User function Template for Java
class Solution {
    public int minCost(int[] height) {
        // code here
        int dp[] = new int[height.length];
        return minCost(height.length-1 , height,dp);
        
    }
    public int minCost(int indx , int[]height , int[]dp){
        if(indx == 0){
            return 0;
        }
        if(dp[indx] != 0){
            return dp[indx];
        }
        
        int jump1 = minCost(indx-1 , height,dp) + Math.abs(height[indx] - height[indx-1]);
        int jump2 = Integer.MAX_VALUE;
        if(indx > 1){
            jump2 = minCost(indx-2, height,dp) + Math.abs(height[indx] - height[indx-2]);
        }
        return dp[indx]=Math.min(jump1 , jump2);
    }
}