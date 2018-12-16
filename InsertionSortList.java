/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class insertionSortList {
    public ListNode insertionSortList(ListNode head) {
        
        if(head == null) return null;
        
        ListNode previousLoopNode = null;
        ListNode loopNode = head;
         
        ListNode focusedNode = head;
        ListNode previousNode = null;
        
        while(focusedNode != null) {
            
            while(loopNode != focusedNode && loopNode.val <= focusedNode.val) {                    
                previousLoopNode = loopNode;
                loopNode = loopNode.next;                
            }
            
            if(loopNode == focusedNode) {
                loopNode = head;
                previousLoopNode = null;
                previousNode = focusedNode;
                focusedNode = focusedNode.next;
            } else if(previousLoopNode == null) {
                previousNode.next = focusedNode.next;
                focusedNode.next = loopNode;
                head = focusedNode;     
                loopNode = head;
                focusedNode = previousNode.next;
            } else {
                previousNode.next = focusedNode.next;
                previousLoopNode.next = focusedNode;
                focusedNode.next = loopNode;
                focusedNode = previousNode.next;
                previousLoopNode = null;
                loopNode = head;
            } 
            
        }
        
        return head;
    }
}