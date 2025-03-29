class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(max < nums[i]){
                max = nums[i];
            }
        }
        int low = 0;
        int high = max;
        int ans = 0;
        while(low <= high){
            int mid = (low + high)/2;
            int divi = calc(nums , mid);
            if(divi <= threshold){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
        
    }
    public int calc(int[]nums , int mid){
        int divi = 0;
        for(int i = 0 ; i < nums.length ; i++){
            divi += Math.ceil((double)nums[i]/(double)mid);  
        }
        return divi;

    }
}