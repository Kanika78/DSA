// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        
        for(int i=0 ; i<grid[0].length;i++){
            if(!vis[0][i] && grid[0][i] == 1){
                dfs(0,i,vis,grid);
            }
            if(!vis[n-1][i] && grid[n-1][i] == 1){
                dfs(n-1,i,vis,grid);
            }
        }
        for(int i=0 ; i<n;i++){
            if(!vis[i][0] && grid[i][0] == 1){
                dfs(i,0,vis,grid);
            }
            if(!vis[i][m-1] && grid[i][m-1] == 1){
                dfs(i,m-1,vis,grid);
            }
        }
        int count = 0;
        for(int i=0 ; i<n;i++){
            for(int j=0 ; j<m;j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int row,int col,boolean[][]vis,int[][]grid){
        vis[row][col] = true;
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};
        for(int i=0 ; i<4 ; i++){
            int nRow = delrow[i] + row;
            int nCol = delcol[i] + col;
            if(nRow < grid.length && nRow>0 && nCol <grid[0].length && nCol>0 && !vis[nRow][nCol] && grid[nRow][nCol]== 1){
                dfs(nRow,nCol,vis,grid);

            }
        }
    }
}