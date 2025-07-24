class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ans[][] = new int[image.length][image[0].length];
        boolean vis[][] = new boolean[image.length][image[0].length];
        for(int i=0 ; i<image.length;i++){
            for(int j=0 ; j<image[0].length;j++){
                ans[i][j] = image[i][j];
            }
        }
        dfs(sr,sc,color,vis,ans,image);
        return ans;
        
    }
    public void dfs(int row,int col,int color,boolean[][]vis , int[][]ans, int[][]image){
        vis[row][col] = true;
        ans[row][col] = color;

        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,-1,0,1};
        for(int i=0;i<4;i++){
            int nRow = delrow[i]+row;
            int nCol = delcol[i]+col;
            if(nRow <ans.length && nRow>=0 && nCol <ans[0].length && nCol>=0 && !vis[nRow][nCol] && image[row][col] == image[nRow][nCol]){
                dfs(nRow,nCol,color,vis,ans,image);

            }
        }
    }
}