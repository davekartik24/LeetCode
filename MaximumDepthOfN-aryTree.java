/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    
    int maxDepth = 0;
    
    public int maxDepth(Node root) {
        
        if(root == null) return 0;       
        
        findMaxDepth(root, 1);
        
        return maxDepth;

    }
    
    public void findMaxDepth(Node input, int depth) {
        
        if(input == null) return ;
        
        if(maxDepth < depth) maxDepth = depth;
        
        for(Node element : input.children) {
            
            findMaxDepth(element, depth + 1);
        }
        
    }
}