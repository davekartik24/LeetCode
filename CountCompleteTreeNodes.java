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
    
    int count = 0;
    
    public int countNodes(TreeNode root) {
        
        nodeCount(root);
        return count;
    }
    
    public void nodeCount(TreeNode root) {
        
        if(root != null) {
            count++;
            if(root.left != null) nodeCount(root.left);
            if(root.right != null) nodeCount(root.right);
        } 
    }
    
    
}