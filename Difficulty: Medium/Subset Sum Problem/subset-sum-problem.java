class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int sum1 = 0;
        for(int i=0 ; i<arr.length ; i++){
            sum1 += arr[i];
        }
        if(sum1 < sum){
            return false;
        }
        boolean dp[] = new boolean[arr.length];
        return subset(0 ,sum,arr,dp);
    }
    public static boolean subset(int indx ,int sum,int arr[],boolean[]dp){
       if(indx == arr.length-1 && (sum == arr[indx] || sum == 0)){
           return true;
       }
       if(sum < 0 || indx >= arr.length){
           return false;
       }
       if(dp[indx] != false){
           return dp[indx];
       }
       return dp[indx] = subset(indx+1 , sum - arr[indx] , arr,dp) || subset(indx+1 , sum, arr,dp);
    }
}
