

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        
        ListNode previousNode = null;
        
        ListNode currentNode = head;
        
        ListNode tempNode = null;
        
        while(currentNode != null) {
            
            tempNode = currentNode;
            currentNode = currentNode.next;
            tempNode.next = previousNode;
            previousNode = tempNode;
        }
        
        return tempNode;
        
    }
}