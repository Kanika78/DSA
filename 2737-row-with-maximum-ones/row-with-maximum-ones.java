class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int max_one = 0;
        int indx = 0;
        for(int i=0 ; i<mat.length;i++){
            Arrays.sort(mat[i]);
            int firstOccur = FirstOccurOfOne(mat[i] , 1);
            int cnt = firstOccur == -1 ? 0 : mat[0].length - firstOccur;
            if(cnt > max_one){
                max_one = cnt;
                indx = i;
            }
        }
        return new int[]{indx,max_one};
        
    }
    public int FirstOccurOfOne(int[] arr , int target){
        int low = 0;
        int high = arr.length-1;
        int ans = -1;

        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] == target){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid +1;
            }
        }
        return ans;
    }
}