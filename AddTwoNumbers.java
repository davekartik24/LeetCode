/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode focusedNode1 = l1;
        int length1 = 0;
        int length2 = 0;
        ListNode focusedNode2 = l2;
        
        while(focusedNode1 != null) {
            length1++;
            focusedNode1 = focusedNode1.next;
        }
        
        while(focusedNode2 != null) {
            length2++;
            focusedNode2 = focusedNode2.next;
        }
        
        if(length1 == 0 && length2 == 0) return null;
        
        if(length1 >= length2) {
            focusedNode1 = l1;
            focusedNode2 = l2;
        } else {
            focusedNode1 = l2;
            focusedNode2 = l1;
        }
        
        ListNode newList = null;
        ListNode resultRoot = null;
        
        int carry = 0;
        
        while(focusedNode2 != null) {
            int value = focusedNode1.val + focusedNode2.val;
            int toAdd = (value + carry) % 10;

            if(newList == null) {
                newList = new ListNode(toAdd);
                resultRoot = newList;
            } else {       
                ListNode actualNode = new ListNode(toAdd);
                newList.next = actualNode;
                newList = actualNode;
            }
            
            focusedNode1 = focusedNode1.next;
            focusedNode2 = focusedNode2.next;
            
            carry = (value + carry) / 10;
            
            
        }
        
        while(focusedNode1 != null) {
            int value = focusedNode1.val;
            int toAdd = (value + carry) % 10;
            
            ListNode actualNode = new ListNode(toAdd);
            newList.next = actualNode;
            newList = actualNode;
            
            carry = (value + carry) / 10;
            focusedNode1 = focusedNode1.next;
            
        }
        
        if(carry != 0) {
            ListNode actualNode = new ListNode(carry);
            newList.next = actualNode;
        }
         
        return resultRoot;
         
    }
            
}