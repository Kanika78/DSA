class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0;
        int j = 0;
        int ZeroCount = 0;
        int maxLen = 0;
        while(j < nums.length){
            if(nums[j] == 0){
                ZeroCount++;
            }
            while(ZeroCount > 1){
                if(nums[i] == 0){
                    ZeroCount--;
                }
                i++;
            }
            maxLen = Math.max(maxLen , j-i);
            j++;
        }
        if(ZeroCount == 0){
            return nums.length-1;
        }
        return maxLen;
        
    }
}