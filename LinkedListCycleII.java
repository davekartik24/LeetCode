/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        
        ListNode normalNode = head;
        ListNode fastNode = head;
        
        
        while(fastNode != null && fastNode.next != null) {
            
            normalNode = normalNode.next;
            fastNode = fastNode.next.next;
            
            if(normalNode == fastNode) {  
                while(normalNode != head) {
                    
                    head = head.next;
                    normalNode = normalNode.next;
                }
                
                return normalNode;
            }
            
        }
        
        return null;
        
    }
}