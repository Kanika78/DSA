/*
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Solution {
    public boolean isSumProperty(Node root) {
        //  code here
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        int leftData = (root.left != null) ? root.left.data: 0;
        int rightData = (root.right != null) ? root.right.data : 0;
        
        return (root.data == leftData + rightData) && 
                isSumProperty(root.left) &&
                isSumProperty(root.right);
        
        
    }
    
}