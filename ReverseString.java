

class ReverseString {
	
    public String reverseString(String s) {
        
        int inputLength = s.length();
        
        if(s == null || inputLength == 0) return "";
        
        int i = 0;
        
        inputLength--;
        
        char[] inputCharArray = s.toCharArray();
        
        while(i < inputLength) {
            
            char temp = inputCharArray[i];
            inputCharArray[i] = inputCharArray[inputLength];
            inputCharArray[inputLength] = temp;
            i++;
            inputLength--;
        }
        
        return new String(inputCharArray);
        
    }
}