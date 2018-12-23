class Solution {
    public boolean isPalindrome(int x) {
        
        String input = Integer.toString(x);
        
        int i = 0;
        int j = input.length() - 1;
        
        while(i < j && i != j) {
            
            if(input.charAt(i) != input.charAt(j)) return false;
            i++;
            j--;
        }
         
        return true;
        
    }
}