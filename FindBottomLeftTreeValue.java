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
    public int findBottomLeftValue(TreeNode root) {
        
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        
        queue.addLast(root);

        TreeNode resultNode = null;
        
        while(!queue.isEmpty()) {
            
            resultNode = queue.removeFirst();
            
            if(resultNode.right != null) queue.addLast(resultNode.right);
            if(resultNode.left != null) queue.addLast(resultNode.left);
            
        }
        
        return resultNode.val;
        
    }
}