public class ReverseWordInString {
    
    public String reverseWords(String s) {
        
        if(s == "") return "";
        
        s = s.trim();
        
        String[] inputArray = s.split("\\s+");
        
        int length = inputArray.length;
        
        if(length == 1) return s;
        
        reverse(inputArray);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < length - 1; i++) {
            
            sb.append(inputArray[i]);
            
            sb.append(" ");
     
        }
        
        sb.append(inputArray[length - 1]);
        
        return sb.toString();
    }
    
    public void reverse(String[] inputArray) {
        
        int i = 0;
        int j = inputArray.length - 1;
        
        while(i < j) {
            
            String temp = inputArray[i];
            inputArray[i++] = inputArray[j];
            inputArray[j--] = temp;
        }
    }
}