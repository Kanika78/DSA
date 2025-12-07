class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int dp[][] = new int[arr.length][sum+1];
        for(int r[] : dp){
            Arrays.fill(r,-1);
            
        }
        solve(arr.length-1,sum,arr,dp);
        return dp[arr.length-1][sum] == 1;
        
        
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