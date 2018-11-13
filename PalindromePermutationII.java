
import java.util.*;

public class PalindromePermutationII {
    
    public List<String> resultList = new ArrayList<>();
    
    public List<String> generatePalindromes(String s) {
        
        char[] inputCharArray = s.toCharArray();
        
        ArrayList<ArrayList<Character>> evenOddCharList = isPossiblePalindrome(inputCharArray);
        
        if(evenOddCharList == null) { 
            return resultList;
        } else {
            
            permute(evenOddCharList.get(0), evenOddCharList.get(1));
            
        }
        
        return resultList;   
    }
    
    public void permute(ArrayList<Character> toPermute, ArrayList<Character> oddElement) {
        
        StringBuilder sb = new StringBuilder(toPermute.size());
            
        for(Character c : toPermute) {
                
            sb.append(c);
        }
        
        if(oddElement.size() == 0) {
            
            permutation(sb.toString(), "");
        } else {
            
            permutation(sb.toString(), "", oddElement.get(0));
        }
    }
    
    public void permutation(String input, String prefix) {
        
        if(input.length() == 0) {
            
            resultList.add(prefix + new StringBuilder(prefix).reverse().toString());
        } else {
            
            for(int i = 0; i < input.length(); i++) {
                
                String editList = input.substring(0, i) + input.substring(i+1);
                
                permutation(editList, prefix + input.charAt(i));
            }
        }
    }
    
    public void permutation(String input, String prefix, Character oddChar) {
        
        if(input.length() == 0) {
            
            resultList.add(prefix + oddChar + new StringBuilder(prefix).reverse().toString());
        } else {
            
            for(int i = 0; i < input.length(); i++) {
                
                String editList = input.substring(0, i) + input.substring(i+1);
                
                permutation(editList, prefix + input.charAt(i), oddChar);
            }
        }
    }
    
    
    public ArrayList<ArrayList<Character>> isPossiblePalindrome(char[] inputCharArray) {
        
        ArrayList<ArrayList<Character>> returnList = new ArrayList<>(2);
        
        ArrayList<Character> evenCountChar = new ArrayList<>();
        
        ArrayList<Character> oddCountChar = new ArrayList<>();
        
        int[] hashTable = new int[26];
        
        int oddCount = 0;
        
        for(char element : inputCharArray) {
            
            hashTable[element - 'a']++;
        }
        
        for(int i = 0; i < 26; i++) {
            
            if((hashTable[i] % 2) != 0) {
                
                ++oddCount;
                
                if(oddCount > 1) {
                    
                    return null;
                }
                
                oddCountChar.add((char)('a' + i));
            } else {

            	if(hashTable[i] != 0) {
            		
            		evenCountChar.add((char)('a' + i));
            	}
                
                
            }
        }
        
        returnList.add(evenCountChar);
        returnList.add(oddCountChar);
        
        return returnList;
    }

    public static void main(String[] args) {

    	PalindromePermutationII testInstace = new PalindromePermutationII();

    	System.out.println(testInstace.generatePalindromes("aabb"));
    }
}