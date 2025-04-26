class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        if(pq.size() == 2){

        }

        for(int i=0 ; i<stones.length ; i++){
            pq.add(stones[i]);
        }

        while(pq.size() > 1){
            int stone1 = pq.remove();
            int stone2 = pq.remove(); 

            if(stone1 == stone2){
                continue;   
            }
            else{
                int newStone = stone1 - stone2;
                pq.add(newStone);
            }
        }
        if(pq.isEmpty()){
            return 0;
        }
        return pq.peek();
    }
}