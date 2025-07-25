class Solution {
    class Pair{
        int row;
        int col;
        int step;
        Pair(int row,int col,int step){
            this.row = row;
            this.col = col;
            this.step = step;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int[][] vis = new int[mat.length][mat[0].length];
        int ans[][] = new int[mat.length][mat[0].length];

        Queue<Pair> q = new LinkedList<>();

        for(int i=0 ; i<mat.length;i++){
            for(int j=0 ; j<mat[0].length;j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 1;
                }
            }
        }
        bfs(q,vis,ans,mat);
        return ans;
        
    }
    public void bfs(Queue<Pair> q,int[][] vis,int ans[][],int mat[][]){
        while(!q.isEmpty()){
            Pair zero = q.remove();
            int r = zero.row;
            int c = zero.col;
            int stp = zero.step;

            ans[r][c] = stp;

            int delrow[] = {-1,0,1,0};
            int delcol[] = {0,-1,0,1};
            for(int i=0 ; i<4 ; i++){
                int nRow = delrow[i] + r;
                int nCol = delcol[i] + c;
                if(nRow >= 0 && nRow <mat.length && nCol >= 0 && nCol<mat[0].length && vis[nRow][nCol] == 0){
                    q.add(new Pair(nRow,nCol,stp+1));
                    vis[nRow][nCol] = 1;
                }
            }
        }
    }
}