

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        TreeNode focusedNode = root;
        
        TreeNode previousNode = null;
        
        while(focusedNode != null) {
            
            previousNode = focusedNode;
            
            if(focusedNode.val > val) {
                
                focusedNode = focusedNode.left;
            } else {
                
                focusedNode = focusedNode.right;
            }
        }
        
        if(previousNode.val > val) {
            
            previousNode.left = new TreeNode(val);
        } else {
            
            previousNode.right = new TreeNode(val);
        }
        
        return root;
         
    }
}