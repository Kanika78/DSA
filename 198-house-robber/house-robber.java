class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp , -1);
        return solve(nums.length-1, nums,dp);
        
        
    }
    public int solve(int indx , int[]nums ,int[]dp){
        if(indx == 0){
            return nums[0];
        }
        if(indx == 1){
            return Math.max(nums[1], nums[0]);
        }
        if(dp[indx] != -1){
            return dp[indx];
        }
        int take = nums[indx] + solve(indx-2,nums,dp);
        int notTake = solve(indx-1 , nums,dp);

        dp[indx] = Math.max(take , notTake);
        return dp[indx];
    }
}