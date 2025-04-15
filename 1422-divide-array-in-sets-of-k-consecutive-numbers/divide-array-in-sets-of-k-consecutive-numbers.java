class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0){
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<nums.length ;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i] , map.get(nums[i]) + 1);
            }else{
                map.put(nums[i] , 1);

            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int key : map.keySet()){
            pq.add(key);
        }

        while(!pq.isEmpty()){
            int min = pq.peek();
            for(int i=min ; i< min + k ; i++){
                if(map.containsKey(i)){
                    map.put(i , map.get(i)-1);

                    if(map.get(i) == 0){
                        if(i != min && map.get(min) != 0){
                            return false;
                        }
                        pq.remove();
                    }
                }else{
                    return false;
                }
            }

        }
        return true;
    }
}