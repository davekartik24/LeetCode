class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        
        int count = 0;
        
        char[] sCharArray = s.toCharArray();
        int sLength = s.length();
        
        char[] tCharArray = t.toCharArray();
        int tLength = t.length();
        
        if(sLength == tLength) {
            
            for(int i = 0; i < sLength; i++) {
                
                if(count > 1) return false;
                
                if(sCharArray[i] != tCharArray[i]) count++;
                
            }
            
        } else if(sLength < tLength) {

            if(tLength - sLength > 1) return false;
            
            int i = 0;
            int j = 0;
            
            while(j < tLength) {

                if(i == sLength) {
                    count++;
                    break;
                }
                
                if(count > 1) return false;
                
                if(sCharArray[i] != tCharArray[j]) {
                    
                    count++;
                    j++;
                } else {
                    
                    i++;
                    j++;
                }
            }
        } else {

            if(sLength - tLength > 1) return false;
            
            int i = 0;
            int j = 0;
            
            while(i < sLength) {

                if(j == tLength) {
                    count++;
                    break;
                }
                
                if(count > 1) return false;
                
                if(sCharArray[i] != tCharArray[j]) {
                    
                    count++;
                    i++;
                } else {
                    
                    i++;
                    j++;
                }
            }
            
        }
        
        if(count > 1) {
            
            return false;
        } 
        
        return true;
        
    }
}