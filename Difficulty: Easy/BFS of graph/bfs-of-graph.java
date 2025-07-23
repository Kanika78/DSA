class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ls = new ArrayList<>();
        int[] vis = new int[adj.size()];
        bfs(0 , vis , ls , adj);
        return ls;
        
    }
    public void bfs(int curr , int[]vis , ArrayList<Integer> ls,ArrayList<ArrayList<Integer>> adj){
        vis[curr] = 1;
        Queue<Integer> q = new LinkedList<>();
        
        q.add(curr);
        
        while(!q.isEmpty()){
            int val = q.remove();
            ls.add(val);
            
            for(int neigh : adj.get(val)){
                if(vis[neigh] != 1){
                    vis[neigh] = 1;
                    q.add(neigh);
                }
            }
        }
    }
}