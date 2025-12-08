class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int[][]dp = new int[nums.length][target+1];
        for(int[]r : dp){
            Arrays.fill(r ,-1);
        }
        return solve(0,nums,target,dp);
    }
    public int solve(int indx,int[]nums,int target,int[][]dp){
        int mod = 1000000007;
        if (indx == nums.length) {
            return target == 0 ? 1 : 0;
        }
        
        if(dp[indx][target] != -1){
            return dp[indx][target];
        }
        int notTake = solve(indx+1,nums,target,dp);
        int take = 0;
        if(nums[indx] <= target){
            take = solve(indx+1,nums,target-nums[indx],dp);
        }
        return dp[indx][target] = (take + notTake)%mod;
        
    }
}