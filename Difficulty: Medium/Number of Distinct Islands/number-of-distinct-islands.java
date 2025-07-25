// User function Template for Java

class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row , int col){
            this.row = row;
            this.col = col;
        }
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        Set<ArrayList<String>> set = new HashSet<>();
        
        for(int i=0 ; i<grid.length;i++){
            for(int j=0 ; j<grid[0].length;j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    ArrayList<String> ls = new ArrayList<>();
                    dfs(i , j , grid,vis,ls,i,j);
                    set.add(ls);
                }
            }
        }
        return set.size();
    }
    public String toString(int r , int c){
        return Integer.toString(r) + " " + Integer.toString(c);
    }
    public void dfs(int row,int col,int[][]grid,boolean[][]vis,ArrayList<String> ls,int baseRow,int baseCol){
        vis[row][col] = true;
        ls.add(toString(row - baseRow , col - baseCol));
        
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};
        for(int i=0 ; i<4 ;i++){
            int nRow = delrow[i] + row;
            int nCol = delcol[i] + col;
            if(nRow >=0 && nRow < grid.length && nCol >=0 && nCol <grid[0].length && !vis[nRow][nCol] && grid[nRow][nCol]==1){
                dfs(nRow,nCol,grid,vis,ls,baseRow,baseCol);
            }
        }
    }
}
