class Solution {
    class Pair implements Comparable<Pair>{
        int el;
        int indx;
        Pair(int el , int indx){
            this.el = el;
            this.indx = indx;
        }
        @Override
        public int compareTo(Pair p2){
            return this.el - p2.el;
        }
    }
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int ans[] = new int[arr.length];
        for(int i=0 ; i<arr.length ; i++){
            pq.add(new Pair(arr[i] , i));
        }
        int rank = 0;
        int prev = Integer.MIN_VALUE;
        while(!pq.isEmpty()){
            Pair val = pq.remove();
            if(val.el > prev){
                rank++;
                ans[val.indx] = rank;
                prev = val.el;
            }
            else if(val.el == prev){
                ans[val.indx] = rank;
                prev = val.el;
            }

        }
        
        return ans;


        
    }
}