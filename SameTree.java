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
    public boolean isSameTree(TreeNode p, TreeNode q) {
         
        Deque<TreeNode> queue = new LinkedList<>();
        
        queue.addLast(p);
        queue.addLast(q);
        
        while(!queue.isEmpty()) {
            
            TreeNode focusedNodeOne = queue.removeFirst();
            TreeNode focusedNodeTwo = queue.removeFirst();
            
            if(focusedNodeOne == null && focusedNodeTwo == null) continue;
            
            if(focusedNodeOne == null || focusedNodeTwo == null) return false;
            
            if(focusedNodeOne.val != focusedNodeTwo.val) return false;
            
            queue.addLast(focusedNodeOne.left);
            queue.addLast(focusedNodeTwo.left);
            queue.addLast(focusedNodeOne.right);
            queue.addLast(focusedNodeTwo.right);
            
        }
        
        return true;
        
        
    }
}