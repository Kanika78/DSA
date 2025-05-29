class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        return helper(0,nums , target ,sum);

      
    }
    public int helper(int indx, int[]nums , int target ,int sum){
        if(indx == nums.length && sum == target){
            return 1;
        }
        if(indx == nums.length && (target<sum || target>sum)){
            return 0;
        }
        int add = helper(indx+1 , nums , target , sum + nums[indx]);
        int sub = helper(indx+1 , nums , target , sum - nums[indx]);

        return add + sub;
    }
}