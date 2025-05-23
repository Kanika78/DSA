class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for(int i=0 ; i<nums.length ; i++){
            if(maxJump < i){
                return false;
            }
            maxJump = Math.max(i + nums[i], maxJump);
        }
        return true;
        
    }
}