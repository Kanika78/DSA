class Solution {
    class Pair implements Comparable<Pair>{
        int key;
        int val;
        Pair(int key , int val){
            this.key = key;
            this.val = val;
        }
        @Override
        public int compareTo(Pair p2){
            return p2.val - this.val;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == k){
            return nums;
        }
        HashMap<Integer , Integer> map = new HashMap<>();
        int ans[] = new int[k];
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0 ; i<nums.length ;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i] , map.get(nums[i])+1);
            }else{
                map.put(nums[i] , 1);
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(Map.Entry<Integer , Integer> entry: map.entrySet()){
            pq.add(new Pair(entry.getKey() , entry.getValue()));
        }

        for(int i=0 ;i<k ;i++){
            list.add(pq.remove().key);
        }
        for(int i=0 ;i<k ;i++){
            ans[i] = list.get(i);
        }
        return ans;

        
    }
}