

class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        
        char[] inputCharArray = s.toCharArray();
        
        int sLength = inputCharArray.length;
        
        int oddCount = 0;
        
        int[] charCount = new int[26];
        
        for(char element : inputCharArray) {
            
            charCount[element - 'a']++;
        }
        
        if(sLength % 2 == 0) {
            
            for(char element : inputCharArray) {
                
                if(charCount[element - 'a'] != 2) return false;
            }
            
        } else {
            
            for(char element : inputCharArray) {
                
                if(oddCount == 0) {
                    
                    if(charCount[element - 'a'] == 1) {
                        
                        oddCount++;
                    } else {
                      
                        if(charCount[element - 'a'] != 2) return false;
                        
                    }
                }
            }
        }
        
        return true;
    }
}