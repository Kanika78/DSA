class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = pq.size();

        for(int i = 0 ; i < nums.length ; i++){
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.remove();
            }
        }
        
        return pq.peek();
        
    }
}