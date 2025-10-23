class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0 ; i<stalls.length ; i++){
            max = Math.max(max,stalls[i]);
            min = Math.min(min,stalls[i]);
        }
        int ans = 0;
        int low = 1;
        int high = max - min;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canPlaceCow(stalls,mid,k) == true){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
    public boolean canPlaceCow(int[] arr , int dist , int cows){
        int cntCows = 1;
        int lastIndx = arr[0];
        for(int i=1 ; i<arr.length ; i++){
            if(arr[i] - lastIndx >= dist){
                cntCows++;
                lastIndx = arr[i];
            }
        }
        if(cntCows >= cows){
            return true;
        }
        return false;
    }
}
