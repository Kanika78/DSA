class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return subarray(nums , goal) - subarray(nums , goal-1);
    }
    public int subarray(int[] nums, int goal){
        if(goal < 0){
            return 0;
        }
        int l = 0;
        int r = 0;
        int sum = 0;
        int cnt = 0;
        while(r < nums.length){
            sum += nums[r];
            while(sum > goal){
                sum -= nums[l];
                l++;
            }
            cnt += r-l+1;
            r++;
        }
        return cnt;
    }
}