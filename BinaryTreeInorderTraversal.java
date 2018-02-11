/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        
         List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        
       
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(root != null) {
            
            stack.push(root);
            root = root.left;
        }
        
        while(!stack.isEmpty()) {
            
            root = stack.pop();
            
            result.add(root.val);
            
            if(root.right != null) {
                
                root = root.right;
                
                while(root != null) {
                    
                    stack.push(root);
                    root = root.left;
                }
            } 
        }
        
        return result;
        
    }
}