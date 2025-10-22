class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0;
        int j = 0;
        int lastIndx_Zero = -1;
        int maxLen = 0;
        while(j < nums.length){
            if(nums[j] == 0){
                i = lastIndx_Zero + 1;
                lastIndx_Zero = j;
            }
            maxLen = Math.max(maxLen , j-i);
            j++;
        }
        
        return maxLen;
        
    }
}