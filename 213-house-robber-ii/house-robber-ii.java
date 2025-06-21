class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int dp[] = new int[nums.length+1];
        int dp1[] = new int[nums.length+1];

        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();

        Arrays.fill(dp , -1);
        Arrays.fill(dp1 , -1);

        for(int i=0 ; i<nums.length ; i++){
            if(i != 0){
                temp1.add(nums[i]);
            }
            if(i != nums.length-1){
                temp2.add(nums[i]);
            }
        }
        return Math.max(solve(temp1 , 0,dp) , solve(temp2 , 0,dp1));
        
    }
    public int solve(ArrayList<Integer> temp , int indx, int[]dp){
        if(indx == temp.size()-1){
            return temp.get(temp.size()-1);
        }
        if(indx >= temp.size()){
            return 0;
        }
        if(dp[indx] != -1){
            return dp[indx];
        }
        int pick = temp.get(indx) + solve(temp ,indx+2,dp);
        int notPick = solve(temp,indx+1,dp);
        return dp[indx] = Math.max(pick , notPick);
    }
}