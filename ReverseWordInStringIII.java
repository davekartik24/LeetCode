class ReverseWordInString {
    public String reverseWords(String s) {
        
        String[] sArray = s.split(" ");       
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < sArray.length; i++) {
            
            sArray[i] = reverse(sArray[i]);
        }
        
        
        for(int i = 0; i < sArray.length - 1; i++) {
            sb.append(sArray[i]);
            sb.append(" ");
        }
        
        sb.append(sArray[sArray.length - 1]);
        
        return sb.toString();
        
    }
    
    public String reverse(String s) {
        
        char[] sArray = s.toCharArray();
        
        int i = 0;
        int j = sArray.length - 1;
        
        while(i < j) {
            
            char temp = sArray[i];
            sArray[i++] = sArray[j];
            sArray[j--] = temp;
        }
        
        return new String(sArray);
    } 
}