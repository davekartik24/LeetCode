class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        
        String output = "";
        String result = "";
        
        for(int i = 0; i < s.length(); i++) {
            
            output = palindrom(s, i, i);
            
            if(output.length() > result.length()) {
                
                result = output;
            }
            
            output = palindrom(s, i, i + 1);
            
            if(output.length() > result.length()) {
                
                result = output;
            }
            
        }
        
        return result;
    }
    
    public String palindrom(String s, int left, int right) {
        
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            
            left--;
            right++;
        }
        
        return s.substring(left + 1, right);
    } 
}