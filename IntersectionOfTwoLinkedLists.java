

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lenghtOne = 0;
        ListNode focusedNodeOne = headA;
        
        int lengthTwo = 0;
        ListNode focusedNodeTwo = headB;
        
        int difference = 0;
        
        while(focusedNodeOne != null) {
            focusedNodeOne = focusedNodeOne.next;
            lenghtOne++;
        }
        
        while(focusedNodeTwo != null) {
            focusedNodeTwo = focusedNodeTwo.next;
            lengthTwo++;
        }
        
        if(lenghtOne > lengthTwo) {
            focusedNodeOne = headA;
            focusedNodeTwo = headB;
            difference = lenghtOne - lengthTwo;
        } else {
            focusedNodeOne = headB;
            focusedNodeTwo = headA;
            difference = lengthTwo - lenghtOne;
        }
        
        for(int i = 0; i < difference; i++) {
            
            focusedNodeOne = focusedNodeOne.next;
        }
        
        while(focusedNodeOne != null) {
            
            if(focusedNodeOne.equals(focusedNodeTwo)) return focusedNodeOne;
            
            focusedNodeOne = focusedNodeOne.next;
            focusedNodeTwo = focusedNodeTwo.next;
            
        }
        
        return focusedNodeOne;
        
    }
}