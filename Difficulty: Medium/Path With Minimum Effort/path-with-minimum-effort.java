
class Solution {
     static class Pair{
        int row;
        int col;
        int diff;
        Pair(int row,int col,int diff){
            this.row = row;
            this.col = col;
            this.diff = diff;
        }
    }
    static int delrow[] = {-1,0,1,0};
    static int delcol[] = {0,1,0,-1};
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        int[][] dist = new int[heights.length][heights[0].length];
        for(int[]r : dist){
            Arrays.fill(r , (int)1e9);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> x.diff - y.diff);
        dist[0][0] = 0;
        pq.add(new Pair(0,0,0));
        
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int row = p.row;
            int col = p.col;
            int diff = p.diff;
            for(int i=0 ; i<4 ; i++){
                int nrow = delrow[i] + row;
                int ncol = delcol[i] + col;
                if(nrow < heights.length && nrow >=0 && ncol < heights[0].length && ncol >=0){
                    int newEff = Math.max(Math.abs(heights[nrow][ncol]-heights[row][col]) , diff);
                    if(newEff < dist[nrow][ncol]){
                        dist[nrow][ncol] = newEff;
                        pq.add(new Pair(nrow,ncol,newEff));
                    }
                }

            }
        }
        return dist[heights.length-1][heights[0].length-1];
        

        
    }
}
