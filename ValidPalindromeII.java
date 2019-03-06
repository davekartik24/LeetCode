class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        
        char[] inputArray = s.toCharArray();
        
        int start = 0;
        int end = inputArray.length - 1;
        
        while(start  end) {
            
            if(inputArray[start] != inputArray[end]) {
                return charDelete(inputArray, start + 1, end)  charDelete(inputArray, start, end - 1);
            } else {
                start++;
                end--;
            }
        }
        
        return true;
    }
    
    public boolean charDelete(char[] inputArray,int start,int end) {
        while(start  end) {
            if(inputArray[start] != inputArray[end]) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        
        return true;
    }
}