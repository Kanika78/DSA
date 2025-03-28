class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i = 0 ; i < piles.length ; i++){
            if(max < piles[i]){
                max = piles[i];
            }
        }
        int low = 1;
        int high = max;
        int minhrs = 0;
        while(low <= high){
            int mid = (low + high)/2;
            int hrs = calcHrs(piles , mid);
            if(hrs <= h){
                minhrs = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return minhrs;
        
        
    }
    public int calcHrs(int[]piles , int mid){
        int hrs = 0;
        for(int i = 0 ; i < piles.length ; i++){
            hrs += Math.ceil((double)piles[i]/(double)mid);  
        }
        return hrs;

    }
}