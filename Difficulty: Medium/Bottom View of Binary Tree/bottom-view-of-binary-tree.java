/*
class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
*/

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
    static class Pair {
        Node node;
        int line;
        Pair(Node node, int line) {
            this.node = node;
            this.line = line;
        }
    }

    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ls = new ArrayList<>();
        if (root == null) return ls;

        // TreeMap keeps horizontal distance keys sorted
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.remove();
            Node node = curr.node;
            int line = curr.line;

            // Only put first node for each vertical line
        
            map.put(line, node.data);
            if (node.left != null) {
                q.add(new Pair(node.left, line - 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, line + 1));
            }
        }

        // Collect results from leftmost to rightmost
        for (int val : map.values()) {
            ls.add(val);
        }
        return ls;
    }
}
