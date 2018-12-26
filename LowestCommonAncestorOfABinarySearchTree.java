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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) return null;
        
        TreeNode focusedNode = root;
        
        while(focusedNode != null) {
         
            if((focusedNode.val > p.val && focusedNode.val < q.val) || (focusedNode.val > q.val && focusedNode.val < p.val)) {
                return focusedNode;
            } else if(focusedNode == p || focusedNode == q){
                if(focusedNode == p) {
                    return p;
                } else {
                    return q;
                }
            } else if(focusedNode.val < p.val && focusedNode.val < q.val) {
                
                focusedNode = focusedNode.right;
            } else {
                focusedNode = focusedNode.left;
            }
        }
        
        return null;
    }
}