class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int buyPrice = Integer.MAX_VALUE;
        int profit = 0;

        for(int i=0 ; i<prices.length ; i++){
            if(buyPrice > prices[i]){
                buyPrice = prices[i];
            }else{
                profit = prices[i] - buyPrice;
                max = Math.max(profit , max);
            }
        }
        return max;
        
    }
}