class Solution {
    //this solution is better with space complexity(works well with +&-)
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int prefixSum = 0;
        int sum = 0;
        int cnt = 0;
        for(int i=0 ; i<nums.length ; i++){
            sum += nums[i];
            prefixSum = sum - goal;
            if(map.containsKey(prefixSum)){
                cnt += map.get(prefixSum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
        
    }
}