/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair {
        TreeNode node;
        int line;
        Pair(TreeNode node, int line) {
            this.node = node;
            this.line = line;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ls = new ArrayList<>();
        if (root == null) return ls;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.remove();
            TreeNode node = curr.node;
            int line = curr.line;

        
            if (!map.containsKey(line)) {
                map.put(line, node.val);
            }
            if (node.right != null) {
                q.add(new Pair(node.right, line + 1));
            }
            if (node.left != null) {
                q.add(new Pair(node.left, line + 1));
            }
        }
        for (int val : map.values()) {
            ls.add(val);
        }
        return ls;
        
    }
}