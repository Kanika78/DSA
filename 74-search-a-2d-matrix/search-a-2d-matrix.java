class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length;
        for(int i = 0 ; i < matrix.length ; i++){
            if(check(matrix[i] , m ,target)){
                return true;
            }
        }
        return false;
        
    }
    public boolean check(int arr[] , int m , int target){
        int low = 0;
        int high = m-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] == target){
                return true;
            }
            else if(arr[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }
}