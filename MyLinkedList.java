class MyLinkedList {
    
    
    Node root;
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        
        Node focusedNode = root;
        
        while(focusedNode != null && index > 0) {
            
            focusedNode = focusedNode.next;
            index--;
        }
        
        if(focusedNode == null) return -1;
        
        return focusedNode.value;
        
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {

        Node newNode = new Node(val);

        if(root != null) {
            root.previous = newNode;
        }
        newNode.next = root;    
        root = newNode;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {

        Node newNode = new Node(val);
        Node focusedNode = root;

        if(focusedNode == null) {
            root = newNode;
            return;
         }
 
        while(focusedNode.next != null) {

            focusedNode = focusedNode.next;
        }

        focusedNode.next = newNode;
        newNode.previous = focusedNode;
        
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {

        if(root == null || index == 0) { 
            addAtHead(val);
            return;
        }

        Node newNode = new Node(val);

        Node focusedNode = root;

        while(focusedNode.next != null && index > 0) {
            focusedNode = focusedNode.next;
            index--;
        }

        if(index > 1) return;

        if(index == 1) {

            newNode.previous = focusedNode;
            focusedNode.next = newNode;
        } else {

        newNode.next = focusedNode;
        newNode.previous = focusedNode.previous;
        focusedNode.previous = newNode;
        newNode.previous.next = newNode;

    }



        
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

        if(root == null) return;

        Node focusedNode = root;

        if(index == 0) {
            root = focusedNode.next;
            focusedNode.next.previous = null;
            return;
        }

        while(focusedNode.next != null && index > 0) {
            focusedNode = focusedNode.next;
            index--;
        }

        if(index > 0) return;

        if(focusedNode.next == null) {

            focusedNode.previous.next = null;
            return;
        }

        focusedNode.previous.next = focusedNode.next;
        focusedNode.next.previous = focusedNode.previous;

    }
    
    public class Node {
        
        int value;
        Node next;
        Node previous;
        
        public Node(int value) {
            
            this.value = value;
        }
    }
    
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */