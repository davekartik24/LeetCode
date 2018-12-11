/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class AddTwoNumbersll {
    
    public ListNode reverse(ListNode inputFocusedNode) {
        
        ListNode previousNode = null;
        ListNode tempNode = null;
        
        while(inputFocusedNode != null) {
            tempNode = inputFocusedNode.next;
            inputFocusedNode.next = previousNode;
            previousNode = inputFocusedNode;
            inputFocusedNode = tempNode;
        }
        
        return previousNode;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1 == null) return l2;
        
        if(l2 == null) return l1;
        
        ListNode reverseFirstNode = reverse(l1);
        ListNode reverseSecondNode = reverse(l2);
        
        int carry = 0;
        
        int nodesum;
        
        ListNode head = null;
        
        while(reverseFirstNode != null && reverseSecondNode != null) {
            nodesum = (reverseFirstNode.val + reverseSecondNode.val + carry) % 10;
            carry = (reverseFirstNode.val + reverseSecondNode.val + carry) / 10;
            
            if(head == null) {        
                head = new ListNode(nodesum);
            } else {
                ListNode newNode = new ListNode(nodesum);
                newNode.next = head;
                head = newNode;
            }
            
            reverseFirstNode = reverseFirstNode.next;
            reverseSecondNode = reverseSecondNode.next;
            
        }
        
        if(reverseFirstNode == null) {
            
            while(reverseSecondNode != null) {
                
                nodesum = (reverseSecondNode.val + carry) % 10;
                carry = (reverseSecondNode.val + carry) / 10;

                if(head == null) {        
                    head = new ListNode(nodesum);
                } else {
                    ListNode newNode = new ListNode(nodesum);
                    newNode.next = head;
                    head = newNode;
                }
                reverseSecondNode = reverseSecondNode.next;   
                
            }
        } else {
            while(reverseFirstNode != null) {
                
                nodesum = (reverseFirstNode.val + carry) % 10;
                carry = (reverseFirstNode.val + carry) / 10;

                if(head == null) {        
                    head = new ListNode(nodesum);
                } else {
                    ListNode newNode = new ListNode(nodesum);
                    newNode.next = head;
                    head = newNode;
                }
                
                reverseFirstNode = reverseFirstNode.next;
            
            }
            
        }
        
        if(carry != 0) {
            
            if(head == null) {        
                head = new ListNode(carry);
            } else {
                ListNode newNode = new ListNode(carry);
                newNode.next = head;
                head = newNode;
            }
        }
        
        return head;
        
    }
}