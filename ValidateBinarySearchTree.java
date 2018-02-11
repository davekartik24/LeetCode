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
    
    private boolean help(TreeNode p, Integer low, Integer high) {
    
        if (p == null) return true;
        return (low == null || p.val > low) && (high == null || p.val < high) && help(p.left, low, p.val) && help(p.right, p.val, high);
    }
    
    public boolean isValidBST(TreeNode root) {
        
        return help(root, null, null);
        
    }
}