class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int candies[] = new int[n];
        Arrays.fill(candies , 1);

        for(int i=1 ; i<ratings.length ; i++){
            if(ratings[i] > ratings[i-1] && candies[i] <= candies[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }
        //check from right
        for(int i = n-2 ; i >=0 ; i--){
            if(ratings[i]  > ratings[i+1] && candies[i] <= candies[i+1]){
                candies[i] = candies[i+1] + 1;
            }
        }

        int sum = 0;
        for(int i=0 ; i<candies.length ; i++){
            sum += candies[i];
        }

        return sum;
        
    }
}