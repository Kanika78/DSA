class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int cnt = 0;
        int maxlen = 0;
        while(r < nums.length){
            if(nums[r] == 0){
                cnt++;
            }
            while(cnt > k){
                if(nums[l] == 0){
                    cnt--;
                }
                l++;
            }
            maxlen =Math.max(maxlen , r - l + 1);
            r++;
        }
        return maxlen;
        
    }
}