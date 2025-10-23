class Solution {
    public int minTime(int[] arr, int k) {
        // code here
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0 ; i<arr.length ; i++){
            max = Math.max(max , arr[i]);
            sum += arr[i];
        }
        int low = max;
        int high = sum;
        int ans = 0;
        while(low <= high){
            int mid = low + (high -low)/2;
            if(canPaint(arr , mid) > k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
               
        }
        return low;
    }
    public int canPaint(int[] arr , int time){
        int t = 0;
        int painter = 1;
        for(int i=0 ; i<arr.length ; i++){
            if(t + arr[i] <= time){
                t += arr[i];
            }else{
                painter++;
                t = arr[i];
            }
        }
        return painter;
    }
    
}
