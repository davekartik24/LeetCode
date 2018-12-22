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
        
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        int carry = 0;
        int sum = 0;
        
        sum = l1.val + l2.val + carry;
            
        carry = sum / 10;
        
        ListNode finalResultHead = new ListNode(sum % 10);
        ListNode focusedNode = finalResultHead;
        
        l1 = l1.next;
        l2 = l2.next;
        
        
        while(l1 != null && l2 != null) {
            
            sum = l1.val + l2.val + carry;
            
            carry = sum / 10;
             
            focusedNode.next = new ListNode(sum % 10);
            focusedNode = focusedNode.next;
            
            l1 = l1.next;
            l2 = l2.next;
            
        }
        
        if(l1 == null) {
            
            while(l2 != null && carry != 0) {
                
                sum = l2.val + carry;
                carry = sum / 10;
                
                focusedNode.next = new ListNode(sum % 10);
                focusedNode = focusedNode.next;
                
                l2 = l2.next;
                
            }
        } else if(l2 == null) {
            
            while(l1 != null && carry != 0) {
                
                sum = l1.val + carry;
                carry = sum / 10;
                
                focusedNode.next = new ListNode(sum % 10);
                focusedNode = focusedNode.next;
                
                l1 = l1.next;
            }
        }
        
        if(carry != 0) focusedNode.next = new ListNode(carry);
        
        if(l1 != null) focusedNode.next = l1;
        
        if(l2 != null) focusedNode.next = l2;
        
        return finalResultHead;
         
    }
            
}