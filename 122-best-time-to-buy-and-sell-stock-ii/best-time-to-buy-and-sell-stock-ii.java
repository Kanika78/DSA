class Solution {
    public int maxProfit(int[] prices) {
        int canbuy = 1;
        int[][] dp = new int[prices.length][2];
        for(int r[] : dp){
            Arrays.fill(r,-1);
        }
        return solve(0,prices,dp,canbuy);
    }
    public int solve(int indx,int[]prices,int[][]dp,int canbuy){
        if(indx == prices.length){
            return 0;
        }
        int profit = 0;
        if(dp[indx][canbuy]!=-1){
            return dp[indx][canbuy];
        }
        if(canbuy ==1){
            int take = -prices[indx] + solve(indx+1,prices,dp,0);
            int notTake = 0 + solve(indx+1,prices,dp,1);
            profit = Math.max(take , notTake);
        }else{
            int sell = prices[indx] + solve(indx+1,prices,dp,1);
            int notSell = 0 + solve(indx+1,prices,dp,0);
            profit = Math.max(sell , notSell);
        }
        return dp[indx][canbuy]=profit;
    }
}