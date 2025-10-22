class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m * k > bloomDay.length){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0 ; i<bloomDay.length ; i++){
            max = Math.max(max , bloomDay[i]);
            min = Math.min(min , bloomDay[i]);
        }
        int low = min;
        int high = max;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(flowers(bloomDay,mid,k) >= m){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
        
    }
    public int flowers(int bloomDay[], int day, int k){
        int cnt = 0;
        int bouquet = 0;
        for(int i=0 ; i<bloomDay.length ; i++){
            if(bloomDay[i] <= day){
                cnt++;
            }else{
                int b = cnt/k;
                bouquet += b;
                cnt = 0;
            }
        }
        bouquet += cnt / k;
        return bouquet;
    }
}