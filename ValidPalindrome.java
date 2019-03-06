class ValidPalindrome {
    public boolean isPalindrome(String s) {
        
        if(s.equals()) return true;
        
        s = s.toLowerCase();
        char[] inputArray = s.toCharArray();
        
        int start = 0; 
        int end = inputArray.length - 1;
        
        while(start  end) {
            
            if(!isAlphabet(inputArray[start])) {
                
                start++;
                continue;
            }
            
            if(!isAlphabet(inputArray[end])) {
                end--;
                continue;
            }
            
            if(inputArray[start] != inputArray[end]) {
                return false;
            } else {
                start++;
                end--;
            }
        }    
        
        return true;
    }
    
    public boolean isAlphabet(char input) {
        
        return (input = 'a' && input = 'z')  (input = '0' && input = '9');
    } 
}