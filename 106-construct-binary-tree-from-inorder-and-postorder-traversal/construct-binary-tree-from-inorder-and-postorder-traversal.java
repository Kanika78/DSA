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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i=0 ; i<inorder.length ; i++){
            map.put(inorder[i] , i);
        }
        TreeNode root = build(inorder , 0,inorder.length-1 , postorder,0,postorder.length-1 , map);
        return root;
        
    }
    public TreeNode build(int[] inorder , int inStart , int inEnd ,int[]postorder , int postStart ,int postEnd,HashMap<Integer , Integer> map){

        if(inStart > inEnd || postStart > postEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot = map.get(root.val);
        int numLeft = inRoot - inStart;
        int numRight = inEnd - inRoot;

        root.left = build(inorder,inStart,inRoot-1,postorder , postStart,postEnd-numRight-1,map);
        root.right = build(inorder,inRoot+1,inEnd,postorder,postStart+numLeft ,postEnd-1,map);

        return root;
    }
}