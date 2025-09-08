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
    TreeNode target = null;
    public void LevelOrder(TreeNode root , HashMap<TreeNode , TreeNode> map,int start){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0 ; i<size ; i++){
                TreeNode curr = q.remove();
                if(curr.val == start){
                    target = curr;
                }
                if(curr.left != null){
                    q.add(curr.left);
                    map.put(curr.left ,curr);
                }
                if(curr.right != null){
                    q.add(curr.right);
                    map.put(curr.right ,curr);
                }
            }
        }
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode , TreeNode> map = new HashMap<>();
        LevelOrder(root , map,start);
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode , Boolean> vis = new HashMap<>();
        
        int min = 0;
        q.add(target);
        vis.put(target,true);

        while(!q.isEmpty()){
            min++;
            int size = q.size();
            for(int i=0 ; i<size ; i++){
                TreeNode curr = q.remove();
                if(curr.left != null && vis.get(curr.left) == null){
                    q.add(curr.left);
                    vis.put(curr.left , true);
                }
                if(curr.right != null && vis.get(curr.right) == null){
                    q.add(curr.right);
                    vis.put(curr.right , true);
                }
                if(map.get(curr) != null && vis.get(map.get(curr)) == null){
                    q.add(map.get(curr));
                    vis.put(map.get(curr) , true);
                }
            }

        }
        return min-1;
        
    }
}