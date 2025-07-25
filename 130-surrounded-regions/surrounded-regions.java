class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int vis[][] = new int[n][m];
        
        for(int i=0 ; i<m;i++){
            if(vis[0][i]==0 && board[0][i] == 'O'){
                dfs(0,i,vis,board);
            }
            if(vis[n-1][i]==0  && board[n-1][i] == 'O'){
                dfs(n-1,i,vis,board);
            }
        }
        for(int i=0 ; i<n;i++){
            if(vis[i][0]==0  && board[i][0] == 'O'){
                dfs(i,0,vis,board);
            }
            if(vis[i][m-1]==0 && board[i][m-1] == 'O'){
                dfs(i,m-1,vis,board);
            }
        }
        for(int i=0 ; i<n;i++){
            for(int j=0 ; j<m;j++){
                if(vis[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        
    }
    public void dfs(int row,int col,int[][]vis,char[][]board){
        vis[row][col] = 1;
        
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};
        for(int i=0 ; i<4 ; i++){
            int nRow = delrow[i] + row;
            int nCol = delcol[i] + col;
            if(nRow <board.length && nRow>0 && nCol <board[0].length && nCol>0 && vis[nRow][nCol] == 0 && board[nRow][nCol]=='O'){
                dfs(nRow,nCol,vis,board);

            }
        }

    }
}