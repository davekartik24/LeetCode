

class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        
        int alphaString[] = new int[26];
        
        char[] inputString = s.toCharArray();
        
        for(char element : inputString) {
            
           alphaString[element - 'a']++; 
        }
        
        for(char element : inputString) {
            
            if(alphaString[element - 'a'] == 1) return s.indexOf(element);
        }
        
        return -1;
         
    }
}