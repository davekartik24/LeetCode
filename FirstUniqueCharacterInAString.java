

class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        
        int[] lookup = new int[26];
        char[] input = s.toCharArray();
        int length = s.length();
        
        for(int i = 0; i < length; i++) {
            
            lookup[input[i] - 'a']++;
        }
        
        for(int i = 0; i < length; i++) {
            
            if(lookup[input[i] - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
         
    }
}