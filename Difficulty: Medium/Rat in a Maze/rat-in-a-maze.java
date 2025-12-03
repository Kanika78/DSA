class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> ls = new ArrayList<>();
        int vis[][] = new int[maze.length][maze[0].length];
        if(maze[0][0] == 1){
            solve(0 , 0 , vis,maze,"",ls);
        }
        return ls;
        
    }
    public boolean isSafe(int row , int col , int[][]vis , int maze[][]){
        return (row < maze.length && row >= 0 && col < maze[0].length 
        && col >=0 && vis[row][col]==0 && maze[row][col] == 1);
    }
    public void solve(int row , int col , int[][]vis , int maze[][], String path,ArrayList<String> ls){
        if(row == maze.length-1 && col == maze[0].length-1){
            ls.add(path);
            return;
        }
        vis[row][col] = 1;
        if(isSafe(row+1 , col,vis , maze)){
            solve(row+1 , col , vis,maze,path +"D",ls);
        }
        
        if(isSafe(row , col-1,vis , maze)){
            solve(row, col-1 , vis,maze, path + "L",ls);
        }
        if(isSafe(row , col+1 ,vis , maze)){
            solve(row , col+1 , vis,maze,path + "R",ls);
        }
        if(isSafe(row-1 , col,vis , maze)){
            solve(row-1 , col , vis,maze, path+"U",ls);
        }
        vis[row][col] = 0;
    }
}