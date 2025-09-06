/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    static class Pair{
        Node node;
        int line;
        Pair(Node node , int line){
            this.node = node;
            this.line = line;
        }
    }
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> ls = new ArrayList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        
        if(root == null){
            return ls;
        }
        
        q.add(new Pair(root , 0));
        while(!q.isEmpty()){
            Pair curr = q.remove();
            Node node  = curr.node;
            int line = curr.line;

          
            if(map.get(line) == null){
                map.put(line , node.data);
                
            }
            if(node.left != null){
                q.add(new Pair(node.left , line-1));
            }
            if(node.right != null){
                q.add(new Pair(node.right , line+1));
            }
        }
        for(int value : map.values()){
            ls.add(value);
        }
        return ls;
        
    }
}