class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while(low <= high){
            int mid = (low + high)/2;
            if(min > nums[mid]){
                min = Math.min(min , nums[mid]);
            }
            if(nums[high] <= nums[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return min;
        
    }
}