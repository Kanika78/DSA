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
    TreeNode prev = null;
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            TreeNode node = new TreeNode(val);
            if(prev == null){
                root = node;
                return root;
            }
            else if(prev.val < val){
                prev.right = node;
            }else{
                prev.left = node;
            }

        }
        else if(root.val < val){
            prev = root;
            insertIntoBST(root.right,val);
        }
        else{
            prev = root;
            insertIntoBST(root.left,val);
        }
        return root;
    }
}