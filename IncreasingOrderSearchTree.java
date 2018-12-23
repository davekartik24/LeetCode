
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
    
    TreeNode headNode = null;
    TreeNode focusedNode = null;
    
    public TreeNode increasingBST(TreeNode root) {
        
        formBST(root);
        
        return headNode;
        
    }
    
    public void formBST(TreeNode root) {
        
        if(root != null) {
            
            increasingBST(root.left);
            
            if(headNode == null) {
                root.left = null;
                headNode = root;
                focusedNode = root;
                
            } else {
                
                root.left = null;
                focusedNode.right = root;
                focusedNode = focusedNode.right;
            }
            
            increasingBST(root.right);
            
        }
        
    }
}