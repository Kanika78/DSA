class Solution {
    public int climbStairs(int n) {
        if(n <= 2){
            return n; 
        }
        int dp[] = new int[n+1];
        return helper(dp , n);
    }
    public int helper(int[]dp , int n){
        if(n <= 2){
            return n;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = helper(dp ,n-1) + helper(dp , n-2);
        return dp[n];
    
    }
}