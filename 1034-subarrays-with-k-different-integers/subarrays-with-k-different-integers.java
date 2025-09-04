class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return goodArray(nums , k) - goodArray(nums , k-1); 
        
    }
    public int goodArray(int[] nums, int k){
        if(k < 0){
            return 0;
        }
        int cnt = 0;
        int l = 0;
        int r = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(r < nums.length){
            if(map.containsKey(nums[r])){
                map.put(nums[r] , map.get(nums[r])+1);
            }else{
                map.put(nums[r] , 1);
            }
            while(map.size() > k){
                map.put(nums[l] , map.get(nums[l])-1);
                if(map.get(nums[l]) == 0){
                    map.remove(nums[l]);
                }
                l++;
            }
            cnt += r-l+1;
            r++;
        }
        return cnt;
    }
}