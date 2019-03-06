public class WordsInAStringII {
    	
    public void reverseWords(char[] str) {
        
        reverse(str, 0, str.length - 1);
        
        int wordStart = 0;
        
        for(int i = 0; i < str.length; i++) {
            
            if(str[i] == ' ') {
                reverse(str, wordStart, i - 1);
                wordStart = i + 1;
            }
            
        }
        
        reverse(str, wordStart, str.length - 1);  

    }
    
    public void reverse(char[] str, int start, int end) {
        
        while(start < end) {          
            char temp = str[start];
            str[start++] = str[end];
            str[end--] = temp;
        }
    }

}