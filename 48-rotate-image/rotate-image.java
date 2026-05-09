class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0 ; i<matrix.length ; i++){
            for(int j=i+1 ; j<matrix[i].length ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        int j=0;
        int n = matrix[0].length-1;
        while(j <= n){
            for(int i=0 ; i<matrix.length ; i++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n];
                matrix[i][n] = temp;
            }
            j++;
            n--;
        }
        
    }
}