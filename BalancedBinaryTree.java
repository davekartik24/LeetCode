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
    
    boolean balancedFlag = true;
    
    public boolean isBalanced(TreeNode root) {  
        maxDepth(root); 
        return balancedFlag;      
    }
    
    public int maxDepth(TreeNode root) {
        
        if(root == null) return 0;
        
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        
        if(Math.abs(l - r) > 1) balancedFlag = false;
        
        return Math.max(l, r) + 1;
    }
}