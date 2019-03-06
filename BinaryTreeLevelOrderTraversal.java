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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) return result;
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        
        queue.addLast(root);
        
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            
            List<Integer> depth = new ArrayList<>();
            
            for(int i = 0; i < size; i++) {
                
                TreeNode out = queue.removeFirst();
                
                if(out.left != null) queue.addLast(out.left);
                if(out.right != null) queue.addLast(out.right);
                depth.add(out.val);
            
            }
            
            result.add(depth);
             
        }
        
        return result;
        
    }
}