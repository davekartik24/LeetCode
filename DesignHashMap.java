class MyHashMap {
    
    int capacity = 16;
    float loadFactor = 0.45f;
    int size;
    Node[] bucket;

    /** Initialize your data structure here. */
    public MyHashMap() {
        
        bucket = new Node[capacity];
        size = 0;
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        
        Node input = new Node(key, value);
        int hash = hashCode(key);
        
        int index = hash & (capacity - 1);
        
        if(bucket[index] == null) {
            
            bucket[index] = input;
            size++;
        } else {
            
            Node focusedNode = bucket[index];
            
            while(focusedNode != null) {
                
                if(focusedNode.key == key) {
                    
                    focusedNode.value = value;
                    break;
                }
                
                focusedNode = focusedNode.next;
            }
            
            if(focusedNode == null) {
                
                input.next = bucket[index];
                bucket[index] = input;
                size++;
            }

        }
        
        
        if(size > (int)(capacity * loadFactor)) {
            
            capacity = capacity << 1;
            Node[] newBucket = new Node[capacity];

            for(Node element : bucket) {
                
                if(element == null) continue;
                
                Node next = null;
                Node focusedNode = element;
                
                while(focusedNode != null) {
                    next = focusedNode.next;
                    
                    int newHash = hashCode(focusedNode.key);
                    int newIndex = newHash & (capacity - 1);
                    
                    if(newBucket[newIndex] == null) {
                        newBucket[newIndex] = focusedNode;
                        focusedNode.next = null;
                    } else {
                        focusedNode.next = newBucket[newIndex];
                        newBucket[newIndex] = focusedNode;
                    }
                    
                    focusedNode = next;
                }
            }
            
            bucket = newBucket;
        }
        
    }
    
    public int hashCode(int key) {
        
        int hash = 0;
        
        while(key != 0) {
            
            int rem = key % 10;
            
            hash = 31 * hash + rem;
            
            key = key / 10;
        }
        
        return hash;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = hashCode(key);
        
        int index = hash & (capacity - 1);
        
        Node focusedNode = bucket[index];
        
        while(focusedNode != null) {
            if(focusedNode.key == key) {
                return focusedNode.value;
            }
            
            focusedNode = focusedNode.next;
        }
        
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        
        int hash = hashCode(key);
        int index = hash & (capacity - 1);
        
        Node previous = null;
        Node focusedNode = bucket[index];
        
        while(focusedNode != null && focusedNode.key != key) {
            previous = focusedNode;
            focusedNode = focusedNode.next;
        }
        
        if(focusedNode == null) return;
        
        if(previous == null) {
            bucket[index] = focusedNode.next;
        } else {
            previous.next = focusedNode.next;
        }
    }
    
    class Node {
        
        int key;
        int value;
        Node next;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */