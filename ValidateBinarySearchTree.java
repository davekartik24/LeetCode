/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ValidateBinarySearchTree {
    
     public boolean isValidBST(TreeNode root) {
        
        if(root == null) return true;
        
        return validation(root, null, null); 
         
    }
    
    
    public boolean validation(TreeNode focusedNode, TreeNode lowerLimit, TreeNode upperLimit) {
        
        if(focusedNode == null) return true;
        
        if(lowerLimit != null && focusedNode.val <= lowerLimit.val) return false;
        
        if(upperLimit != null && focusedNode.val >= upperLimit.val) return false;
        
        return validation(focusedNode.left, lowerLimit, focusedNode) && validation(focusedNode.right, focusedNode, upperLimit);  
    }
}