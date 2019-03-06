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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        TreeNode focusedNode = root;
        if(root == null) return null;
        
        boolean leftChild = false;
        TreeNode parent = null;
        
        while(focusedNode != null && focusedNode.val != key) {
            parent = focusedNode;
            
            if(focusedNode.val < key) {
                leftChild = false;
                focusedNode = focusedNode.right;
            } else {
                leftChild = true;
                focusedNode = focusedNode.left;
            }
        }
        
        if(focusedNode == null) return root;
        
        if(focusedNode.left == null) {
            if(parent == null) {
              root = focusedNode.right;  
            } else if(leftChild) {
                parent.left = focusedNode.right;
            } else {
                parent.right = focusedNode.right;
            }
        } else if(focusedNode.right == null) {
            if(parent == null) {
              root = focusedNode.left;  
            } else if(leftChild) {
                parent.left = focusedNode.left;
            } else {
                parent.right = focusedNode.left;
            }
        } else {
            
            if(focusedNode.right.left == null) {
                focusedNode.right.left = focusedNode.left; 
                if(parent == null) {
                    root = focusedNode.right;
                } else if(leftChild) {
                    parent.left = focusedNode.right;
                } else {
                    parent.right = focusedNode.right;
                }
            } else {
                TreeNode minfocusedNode = focusedNode.right;
                TreeNode minParent = focusedNode.right;

                while(minfocusedNode.left != null) {
                    minParent = minfocusedNode;
                    minfocusedNode = minfocusedNode.left;
                }
                
                minParent.left = minfocusedNode.right;
                minfocusedNode.left = focusedNode.left;
                minfocusedNode.right = focusedNode.right;
                
                if(parent == null) {
                    root = minfocusedNode;
                } else if(leftChild) {
                    parent.left = minfocusedNode;
                } else {
                    parent.right = minfocusedNode;
                }
            }
        }
        
        return root;
    }
}