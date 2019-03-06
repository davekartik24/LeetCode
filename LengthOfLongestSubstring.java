import java.util.*;

public class LengthOfLongestSubstring {


    public int lengthOfLongestSubstring(String s) {

    	HashSet<Character> duplicateCheck = new HashSet<>();

    	int i = 0;
    	int j = 0;
        int n = s.length();
    	int length = 0;

    	
        while(i < n && j < n) {
            
            if(!duplicateCheck.contains(s.charAt(j))) {
                duplicateCheck.add(s.charAt(j++));
                length = Math.max(length, duplicateCheck.size());
            } else {
                duplicateCheck.remove(s.charAt(i++));
            }
        }        
        
        return length;        
    }

}