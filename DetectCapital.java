

class DetectCapital {
    public boolean detectCapitalUse(String word) {
        
        char[] inputWord = word.toCharArray();
        
        if(inputWord.length > 0 && Character.isLowerCase(inputWord[0])) {
            for(int i = 1; i < inputWord.length; i++) {
                
                if(Character.isUpperCase(inputWord[i])) return false;
            }
            
        } else if(inputWord.length > 1) {
            
            if(Character.isLowerCase(inputWord[1])) {
                
                for(int i = 2; i < inputWord.length; i++) {
                    
                    if(Character.isUpperCase(inputWord[i])) return false;
                }
            } else {
                
                for(int i = 2; i < inputWord.length; i++) {           
                        
                    if(Character.isLowerCase(inputWord[i])) return false;
                    
                }
            
            }
            
        }
        
        return true;
        
    }
}