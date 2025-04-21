class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        int max = 0;
        int count = 0;
        for(int i=0 ; i<costs.length ; i++){
            max = Math.max(max , costs[i]);
        }
        int countArr[] = new int[max+1];
        for (int i = 0; i < n; i++) {
            countArr[costs[i]]++;
        }

        for(int i=1 ; i<countArr.length ; i++){
            int afford = Math.min(countArr[i] , coins/i);
            coins -= afford*i;
            count += afford;
            if(coins < afford){
                break;
            }

        }
        return count;
    }
}