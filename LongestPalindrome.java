class LongestPalindrome {
    public int longestPalindrome(String s) {
        
        int[] charCount = new int[256];
        
        int total = 0;
        
        boolean odd = true;
        
        for(int i = 0; i < s.length(); i++) {
            
            charCount[s.charAt(i)]++;
        }
        
        for(int element : charCount) {
            
            if(element != 0 && element % 2 == 0) {
                total += element; 
            } else if(element != 0) {
                
                total += element - 1;
                
                if(odd) {
                    total++;
                    odd = false;
                }
            }
            
        }
        
        return total;
        
    }
}