class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int stop[] = new int[1001];
        for(int [] trip : trips){
            stop[trip[1]] += trip[0];
            stop[trip[2]] -= trip[0];
        }
        int passenger = 0;
        for(int i=0 ; i < stop.length ; i++){
            passenger += stop[i];
            if(passenger > capacity){
                return false;
            }

        }
        return true;
        
    }
}