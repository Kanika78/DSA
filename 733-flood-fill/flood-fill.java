class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        int original = image[sr][sc];
        dfs(sr,sc,color,vis,image,original);
        return image;
        
    }
    public void dfs(int row,int col,int color,boolean[][]vis , int[][]image,int original){
        vis[row][col] = true;
        image[row][col] = color;

        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,-1,0,1};
        for(int i=0;i<4;i++){
            int nRow = delrow[i]+row;
            int nCol = delcol[i]+col;
            if(nRow <image.length && nRow>=0 && nCol <image[0].length && nCol>=0 && !vis[nRow][nCol] &&image[nRow][nCol]==original){
                dfs(nRow,nCol,color,vis,image,original);

            }
        }
    }
}