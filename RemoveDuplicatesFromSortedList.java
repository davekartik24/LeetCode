

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode focusedNode = head;
        
        while(focusedNode != null && focusedNode.next != null) {
            
            if(focusedNode.val == focusedNode.next.val) {
                
                focusedNode.next = focusedNode.next.next;
            } else{
                
                focusedNode = focusedNode.next;
            }
        }
        
        return head;
    }
}