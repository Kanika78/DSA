class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int arr[] = new int[2];

        for(int i=0 ; i<grid.length;i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(map.containsKey(grid[i][j])){
                    map.put(grid[i][j] , map.get(grid[i][j])+1);
                }else{
                    map.put(grid[i][j] , 1);
                }
            }
        }
        for(int i=0 ; i<grid.length;i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(map.get(grid[i][j]) == 2){
                    arr[0] = grid[i][j];
                    break;
                }
            }
        }
        for(int i=1 ; i<=grid.length * grid.length ; i++){
            if(!map.containsKey(i)){
                arr[1] = i;
            }
        }
        return arr;

        
    }
}