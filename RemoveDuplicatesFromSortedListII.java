/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        
        boolean flag = false;
        
        ListNode previousNode = null;
        ListNode focusedNode = head;
        
        while(focusedNode != null && focusedNode.next != null) {
            
            if(focusedNode.val == focusedNode.next.val) {
                flag = true;
                focusedNode.next = focusedNode.next.next;
            } else {
                
                if(flag) {
                    
                    if(previousNode == null) {
                        
                        head = focusedNode.next;
                        focusedNode = head;
                    } else {
                        
                        previousNode.next = focusedNode.next;
                        focusedNode = focusedNode.next;
                    }
                    
                    flag = false;
                    
                } else {
                    
                    previousNode = focusedNode;
                    focusedNode = focusedNode.next;
                }
                

            }
        }
        
        if(flag) {
            
            if(previousNode == null) {
                        
                head = focusedNode.next;
                focusedNode = head;
            } else {
                        
                previousNode.next = focusedNode.next;
                focusedNode = focusedNode.next;
            }
                    
        }
        
        
        return head;
        
    }
}