class Solution {
    public int maxProfit(int[] prices) {
        int canbuy = 1;
        Integer[][][] dp = new Integer[prices.length][2][3];
        return solve(0,prices,dp,canbuy,2);
    }
    public int solve(int indx,int[]prices,Integer[][][]dp,int canbuy,int transaction){
        if(indx == prices.length || transaction == 0){
            return 0;
        }
        int profit = 0;
        if(dp[indx][canbuy][transaction] != null){
            return dp[indx][canbuy][transaction];
        }
        if(canbuy == 1){
            int take = -prices[indx] + solve(indx+1,prices,dp,0,transaction);
            int notTake = 0 + solve(indx+1,prices,dp,1,transaction);
            profit = Math.max(take , notTake);
        }else{
            int sell = prices[indx] + solve(indx+1,prices,dp,1,transaction-1);
            int notSell = 0 + solve(indx+1,prices,dp,0,transaction);
            profit = Math.max(sell , notSell);
        }
        return dp[indx][canbuy][transaction]=profit;
    }
}