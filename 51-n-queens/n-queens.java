class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ls = new ArrayList<>();
        char[][] chess = new char[n][n];
        for(char[] r : chess){
            Arrays.fill(r,'.');
        }
        solve(0,n,chess,ls);
        return ls;
        
    }
    public void solve(int row,int n,char[][]chess,List<List<String>> ls){
        if(row == n){
            ls.add(print(chess));
            return;
        }
        for(int i=0;i<n;i++){
            if(isSafe(row,i,chess)){
                chess[row][i] = 'Q';
                solve(row+1,n,chess,ls);
                chess[row][i] = '.';
            }
        }
    } 
    public boolean isSafe(int row,int col,char[][]chess){
        for(int i=row-1 ; i>=0 ;i--){
            if(chess[i][col] == 'Q'){
                return false;
            }
        }
        for(int i=row-1 , j=col-1 ; i>=0 && j>=0 ; i--,j--){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }
        for(int i=row-1 , j=col+1 ; i>=0 && j<chess.length ; i--,j++){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public List<String>  print(char[][]chess){
        List<String> ds = new ArrayList<>();
        for(int i=0;i<chess.length;i++){
            String row = new String(chess[i]);
            ds.add(row);
        }
        return ds;
    }
}