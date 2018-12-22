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
    public int minDepth(TreeNode root) {
        
        if(root == null) return 0;
        
        
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        
        return (l ==0 || r == 0) ? Math.max(l, r) + 1 : Math.min(l,r) + 1; 
    }
}