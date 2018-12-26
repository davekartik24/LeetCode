	/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class KthSmallestElementInABST {
    
    int counter = 0;
    Integer result = null;
    
    public int kthSmallest(TreeNode root, int k) {
        
        findTheElement(root, k);
        
        return result;
        
    }
    
    public void findTheElement(TreeNode root, int k) {
        
        if(root == null) return;
        
        findTheElement(root.left, k);
        counter++;
        if(counter == k) result = root.val;
        findTheElement(root.right, k);
     }
}