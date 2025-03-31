class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0;
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            if(max < nums[i]){
                max = nums[i];
            }
        }
        int low = max;
        int high = sum;
        int ans = -1;
        while(low <= high){
            int mid = (low + high)/2;
            int cnt = cntSub(nums , mid);
            if(cnt == k){
                ans = calcSum(nums , mid);
                high = mid - 1;
            }
            else if(cnt > k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        if(ans == -1){
            return low;
        }
        return ans;
        
    }
    public int cntSub(int[] arr , int mid){
        int cnt = 1;
        int currSum = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(currSum + arr[i] <= mid){
                currSum += arr[i];
            }else{
                cnt++;
                currSum = arr[i];
            }
        }
        return cnt;
    }
    public int calcSum(int arr[] , int mid){
        int currSum = 0;
        int maxSum = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(currSum + arr[i] <= mid){
                currSum += arr[i];
            }else{
                currSum = arr[i];
            }
            maxSum = Math.max(maxSum , currSum);
        }
        return maxSum;

    }
}