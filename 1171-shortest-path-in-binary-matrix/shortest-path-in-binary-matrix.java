class Solution {
    class Pair{
        int row;
        int col;
        int len;
        Pair(int row,int col,int len){
            this.row = row;
            this.col = col;
            this.len = len;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dist = new int[grid.length][grid[0].length];
        for(int[]r : dist){
            Arrays.fill(r , (int)1e9);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> x.len - y.len);
        if(grid[0][0] == 0){
            dist[0][0] = 0;
            pq.add(new Pair(0,0,0));
        }
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int row = p.row;
            int col = p.col;
            int len = p.len;

            int delrow[] = {-1,0,1,0,-1,-1,1,1};
            int delcol[] = {0,1,0,-1,-1,1,-1,1};
            for(int i=0 ; i<8 ; i++){
                int nrow = delrow[i] + row;
                int ncol = delcol[i] + col;
                if(nrow < grid.length && nrow >=0 && ncol < grid[0].length && ncol >=0 && grid[nrow][ncol] == 0){
                    if(len + 1 < dist[nrow][ncol]){
                        dist[nrow][ncol] = len + 1;
                        pq.add(new Pair(nrow , ncol,dist[nrow][ncol]));
                    }
                }

            }
        }
        if(dist[grid.length-1][grid[0].length-1] == (int)1e9){
            return -1;
        }
        return dist[grid.length-1][grid[0].length-1] + 1;

        
    }
}