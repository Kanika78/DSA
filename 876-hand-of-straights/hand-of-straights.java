class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<hand.length ;i++){
            if(map.containsKey(hand[i])){
                map.put(hand[i] , map.get(hand[i]) + 1);
            }else{
                map.put(hand[i] , 1);

            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int key : map.keySet()){
            pq.add(key);
        }

        while(!pq.isEmpty()){
            int min = pq.peek();
            for(int i=min ; i< min + groupSize ; i++){
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