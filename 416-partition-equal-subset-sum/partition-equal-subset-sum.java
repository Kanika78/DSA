class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0 ; i<nums.length ; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0){
            return false;
        }
        int target = sum / 2;
        int[][]dp = new int[nums.length][target+1];
        for(int r[] : dp){
            Arrays.fill(r,-1);  
        }
        solve(nums.length-1,target,nums,dp);
        return dp[nums.length-1][target] == 1;
    }
    public static boolean solve(int indx,int target,int[]arr,int[][]dp){
        if(target == 0){
            return true;
        }
        if(indx == 0){
            return arr[0] == target;
        }
        if(dp[indx][target] != -1){
            return dp[indx][target] == 1;
        }
        boolean notTake = solve(indx-1,target,arr,dp);
        boolean take = false;
        if(arr[indx] <= target){
            take = solve(indx-1 , target-arr[indx],arr,dp);
        }
        dp[indx][target] = (take || notTake) ? 1 : 0;
        return dp[indx][target] == 1;
    }
}