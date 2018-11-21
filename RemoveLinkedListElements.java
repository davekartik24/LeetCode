

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        
        ListNode focusedNode = head;
        
        ListNode previousPointer = null;
        
        while(focusedNode != null) {
            
            if(focusedNode.val == val) {
                
                if(previousPointer == null) {
                    
                    head = focusedNode.next;
                } else {
                    
                    previousPointer.next = focusedNode.next;
                    
                }
            } else {
                
                previousPointer = focusedNode;
            }           
            
            focusedNode = focusedNode.next;
        }
        
        return head;
        
    }
}