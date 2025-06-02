class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length ; i++){
            for(int j=0; j<board[0].length ; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean ans = search(i,j,0,board,word);
                    if(ans){
                        return ans;
                    }
                }
            }
        }
        return false;
        
    }
    public boolean search(int row,int col,int indx,char[][] board,String word){
        if(indx == word.length()){
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(indx)) {
            return false;
        }
        board[row][col] = '*';

        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        for(int i=0 ; i<4 ; i++){
            int newRow = row + delrow[i];
            int newCol = col + delcol[i];

            boolean ans = search(newRow,newCol,indx+1,board,word);
            if(ans == true){
                return true;
            }
        }
        board[row][col] = word.charAt(indx);
        return false;

    }
}