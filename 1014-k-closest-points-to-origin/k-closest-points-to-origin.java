class Solution {
    class Pair implements Comparable<Pair>{
        int dist;
        int indx;
        Pair(int dist , int indx){
            this.dist = dist;
            this.indx = indx;
        }
        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist;
        }

    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int ans[][] = new int[k][];

        for(int i = 0 ; i<points.length ; i++){
            int distSq = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            pq.add(new Pair(distSq , i));
        }

        for(int i=0 ; i<k ; i++){
            int indx = pq.remove().indx;
            ans[i] = new int []{points[indx][0] ,points[indx][1]};
        }
        return ans;
        
    }

}