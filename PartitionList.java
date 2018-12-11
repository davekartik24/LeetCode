/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class PartitionList {
    public ListNode partition(ListNode head, int x) {
    
        ListNode replacePointer = null;
        
        ListNode focusedNode  = head;
        
        ListNode previousNode = null;
        
        ListNode currentNodeToReplace = null;   
        
        while(focusedNode != null) {
            
            if(focusedNode.val >= x) {
                    
                    previousNode = focusedNode;
                    focusedNode = focusedNode.next;
                    break;
                } else {
                    
                    replacePointer = focusedNode;
                    previousNode = focusedNode;
                    focusedNode = focusedNode.next;
                }
        }
        
        while(focusedNode != null) {
            
                
                if(focusedNode.val < x) {
                    
                    currentNodeToReplace = focusedNode;
                    
                    if(replacePointer == null) {
                        
                        previousNode.next = focusedNode.next;
                        focusedNode = focusedNode.next;
                        currentNodeToReplace.next = head;
                        head = currentNodeToReplace;
                        replacePointer = currentNodeToReplace;
                        
                    } else {
                        
                        previousNode.next = focusedNode.next;
                        focusedNode = focusedNode.next;
                        currentNodeToReplace.next = replacePointer.next;
                        replacePointer.next = currentNodeToReplace;
                        replacePointer = currentNodeToReplace;
                     
                    }
                    
                    
                } else {
                    
                    previousNode = focusedNode;
                    focusedNode = focusedNode.next;
                }
                
                
            }
        
        return head;
        
    }
}