/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void LevelOrder(TreeNode root , HashMap<TreeNode , TreeNode> map){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0 ; i<size ; i++){
                TreeNode curr = q.remove();
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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode , TreeNode> map = new HashMap<>();
        LevelOrder(root , map);
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode , Boolean> vis = new HashMap<>();
        int dist = 0;
        q.add(target);
        vis.put(target,true);

        while(!q.isEmpty()){
            if(dist == k){
                break;
            }
            dist++;
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
        List<Integer> ls = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            ls.add(curr.val);
        }
        return ls;

        
    }
}