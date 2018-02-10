import java.util.*;

class ValidParentheses {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<Character>();
        
        Hashtable<Character, Character> hT = new Hashtable<Character, Character>();        
        hT.put('{', '}');
        hT.put('(', ')');
        hT.put('[', ']');
        
        for(int i = 0; i < s.length(); i++) {
            
            try {
                if(stack.isEmpty() || (hT.get(stack.peek()) != s.charAt(i))) {

                    stack.push(s.charAt(i));

                } else if(hT.get(stack.peek()) == s.charAt(i)) {

                    stack.pop();
                }
            } catch (Exception e) {
                
                return false;
            }
        }
        
        if(stack.isEmpty()) {
            
            return true;
        }
        
        return false;
        
    }
}