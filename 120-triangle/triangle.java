class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int indx = 0;
        int dp[][] = new int[triangle.size()][triangle.size()];
        for(int r[] : dp){
            Arrays.fill(r , -1);
        }
        return solve(triangle , indx , 0, dp);
        
    }
    public int solve(List<List<Integer>> list, int indx, int ls, int[][]dp){
        if(ls == list.size()){
            return 0;
        }
        if(ls == list.size()-1){
            return list.get(ls).get(indx);
        }
        if(dp[ls][indx] != -1){
            return dp[ls][indx];
        }
        int take = list.get(ls).get(indx) + solve(list , indx , ls+1,dp);
        int notTake = list.get(ls).get(indx) + solve(list , indx+1 , ls+1,dp);

        return dp[ls][indx] = Math.min(take , notTake);

    }
}