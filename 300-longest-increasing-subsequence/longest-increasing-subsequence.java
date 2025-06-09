class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        for(int r[] : dp){
            Arrays.fill(r , -1);
        }
        return solve(nums,n,0,-1,dp);
    }
    public int solve(int[] nums,int n , int curr , int prev,int[][]dp){
        if(curr == n){
            return 0;
        }
        if(dp[curr][prev+1] != -1){
            return dp[curr][prev+1];
        }
        int notTake = 0 + solve(nums,n ,curr+1,prev,dp);
        int take = 0;
        if(prev == -1 || nums[prev] < nums[curr]){
            take = 1 + solve(nums,n , curr+1,curr,dp);
        }
        return dp[curr][prev+1] = Math.max(take , notTake);
    }
}