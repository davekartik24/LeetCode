

class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        int pushedLength = pushed.length;
        int poppedLength = popped.length;
        int i = 0;
        int j = 0;
        
        while(i < pushedLength) {
            if(stack.peek() != null && stack.peek() == popped[j]) {
                
                stack.pop();
                j++;
            } else {
                stack.push(pushed[i]);
                i++;
            }
        }
        
        while(j < poppedLength) {
            if(stack.pop() != popped[j]) {
                return false;
            }
            j++;
        }
        
        return true;
    }
}