/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists == null || lists.length == 0) return null;
        
        if(lists.length == 1) return lists[0];
        
        return sort(lists, 0, lists.length - 1);
    }
    
    public ListNode sort(ListNode[] lists, int start, int end) {
        
        if(start == end) return lists[start];
        
        int mid = (start + end)/2;
        
        ListNode left = sort(lists, start, mid);
        ListNode right = sort(lists, mid + 1, end);
        
        return merge(left, right);
    }
    
    public ListNode merge(ListNode left, ListNode right) {
        
        if(left == null) return right;
        if(right == null) return left;
        
        ListNode focusedNode = null;
        ListNode head = null;
        
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