class Solution {
    public int findSubstringInWraproundString(String p) {
        
        int[] lookup = new int[26];
        
        int incrementCounter = 0;

        int count = 0;
        
        for(int i = 0; i < p.length(); i++) {
            
            if(i != 0 && ((p.charAt(i) - p.charAt(i - 1)) == 1 || (p.charAt(i) - p.charAt(i - 1)) == -25)) {
                incrementCounter++;
            } else {
                incrementCounter = 1;
            }
            
            lookup[p.charAt(i) - 'a'] = Math.max(lookup[p.charAt(i) - 'a'], incrementCounter);
        
        }
        
        for(int i = 0; i < 26; i++) {
            count += lookup[i];
        }
        
        return count;
        
    }
}