// User function Template for Java

class Solution {
    int findMaxSum(int arr[]) {
        // code here
        int dp[] = new int[arr.length+1];
        Arrays.fill(dp , -1);
        return solve(0 , arr,dp);
        
    }
    public int solve(int indx , int[] arr,int[]dp){
        if(indx == arr.length-1){
            return arr[arr.length-1];
        }
        if(indx >= arr.length){
            return 0;
        }
        if(dp[indx] != -1){
            return dp[indx];
        }
        int pick = arr[indx] + solve(indx+2 , arr,dp);
        int notPick = solve(indx+1 , arr,dp);
        return dp[indx] = Math.max(pick , notPick);
    }
}