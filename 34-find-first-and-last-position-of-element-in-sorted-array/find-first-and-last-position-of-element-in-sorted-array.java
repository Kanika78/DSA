class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int start = -1;
        int end = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] >= target){
                if(nums[mid] == target){
                    start = mid;
                }
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        low = start;
        high = nums.length-1;
        while(low <= high && low != -1){
            int mid = (low + high)/2;
            if(nums[mid] <= target){
                if(nums[mid] == target){
                    end = mid;
                }
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        return new int[]{start , end};
        
    }
}