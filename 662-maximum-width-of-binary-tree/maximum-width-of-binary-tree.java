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
    class pair{
        TreeNode node;
        int indx;
        pair(TreeNode node , int indx){
            this.node = node;
            this.indx = indx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Deque<pair> q = new ArrayDeque<>();
        q.add(new pair(root , 0));
        int maxWidth = 0;
        while(!q.isEmpty()){
            int startIndx = q.peekFirst().indx;
            int endIndx = q.peekLast().indx;
            int size = q.size();
            maxWidth = Math.max(maxWidth , endIndx - startIndx+1);

            for(int i=0 ; i<size;i++){
                pair curr = q.removeFirst();
                TreeNode node = curr.node;
                int indx = curr.indx;

                if(node.left != null){
                    q.add(new pair(node.left , 2*indx+1));
                }
                if(node.right != null){
                    q.add(new pair(node.right , 2*indx+2));
                }
            }


        }
        return maxWidth;
        
    }
}