/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        if(head == null) return null;
        
        ListNode firstPreviousNode = null;
        
        ListNode firstNode = head;
        
        for(int i = 1; i < m; i++) {
            
            firstPreviousNode = firstNode;
            firstNode = firstNode.next;
        }
        
        ListNode replacePrevious = null;
        ListNode focusedNode = firstNode;
        
        for(int i = 0; i <= (n - m); i++) {
            
            ListNode tempNode = focusedNode.next;
            focusedNode.next = replacePrevious;
            replacePrevious = focusedNode;
            focusedNode = tempNode;
        }
        if(m == 1) {
            if(focusedNode == null) {
                return replacePrevious;
            }
            firstNode.next = focusedNode;
            return replacePrevious;
        }
        firstNode.next = focusedNode;
        firstPreviousNode.next = replacePrevious;
        
        return head;
    }
}