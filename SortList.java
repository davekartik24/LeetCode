/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        int length = 0;
        
        ListNode focusedNode = head;
        
        while(focusedNode != null) {
            length++;
            focusedNode = focusedNode.next;
        }
        
        return sort(head, 0, length - 1);
        
    }
    
    public ListNode sort(ListNode head, int start, int end) {
        
        if(start == end) return head;
        
        int mid = (start + end) / 2;
        
        ListNode secondHead = head;
        ListNode previousNode = null;
        
        
        for(int i = start; i <= mid; i++) {
            previousNode = secondHead;
            secondHead = secondHead.next;
        }
        
        previousNode.next = null;
        
        ListNode left = sort(head, start, mid);
        ListNode right = sort(secondHead, mid + 1, end);
        
        return merge(left, right);
    }
    
    public ListNode merge(ListNode left, ListNode right) {
    
        ListNode head = null;
        ListNode focusedNode = null;
        
        while(left != null && right != null) {
            
            if(left.val < right.val) {
                
                if(focusedNode == null) {
                    focusedNode = left;
                    head = focusedNode;
                } else {
                    focusedNode.next = left;
                    focusedNode = left;
                }
                
                left = left.next;
            } else {
                
                if(focusedNode == null) {
                    focusedNode = right;
                    head = focusedNode;
                } else {
                    focusedNode.next = right;
                    focusedNode = right;
                }
                
                right = right.next;
            }
        }
        
        if(left != null) focusedNode.next = left;
        
        if(right != null) focusedNode.next = right;
        
        return head;
    }
} 