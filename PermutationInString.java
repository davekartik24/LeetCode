class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        
        int s1Length = s1.length();
        
        int s2Length = s2.length();
        
        int[] hashTable = new int[26]; 
        
        
        if(s1Length > s2Length) return false;
        
        char[] s1CharArray = s1.toCharArray();
        char[] s2CharArray = s2.toCharArray();
        
        for(char element : s1CharArray) {
            
            hashTable[element - 'a']++;  
        }
        
        for(int i = 0; i < (s2Length - (s1Length - 1)); i++) {
            
            int k = 0;
            int[] hashTableCheck = Arrays.copyOf(hashTable, 26);
            
            for(int j = 0; j < s1Length; j++) {
                
                if(hashTableCheck[s2CharArray[i + j] - 'a'] == 0) break;
                hashTableCheck[s2CharArray[i + j] - 'a']--;
            }
            
            for(int j = 0; j < s1Length; j++) {
                
                if(hashTableCheck[s1CharArray[j] - 'a'] != 0) {
                    break; 
                } else {
                    
                    k++;
                }
            }
            
            if(k == s1Length) return true;
            
         }
        
        return false;
        
    }
}