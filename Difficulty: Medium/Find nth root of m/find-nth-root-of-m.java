class Solution {
    public int nthRoot(int n, int m) {
        // code here
        int low = 1;
        int high = m;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            long root = (long)Math.pow(mid , n);
            if(root == m){
                ans = mid;
                break;
            }
            else if(root < m){
                low =mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
}