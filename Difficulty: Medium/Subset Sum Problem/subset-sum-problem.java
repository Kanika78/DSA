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
        return subset(0 ,sum,arr);
    }
    public static boolean subset(int indx ,int sum,int arr[]){
       if(indx == arr.length-1 && (sum == arr[indx] || sum == 0)){
           return true;
       }
       if(sum < 0 || indx >= arr.length){
           return false;
       }
       return subset(indx+1 , sum - arr[indx] , arr) || subset(indx+1 , sum, arr);
    }
}
