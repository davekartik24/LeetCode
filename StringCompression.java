class StringCompression {
    
    int writeIndex = 0; 
    
    public int compress(char[] chars) {
        
        int charLength = chars.length;
        
        if(charLength == 0) return 0;
               
        int count = 1;
        
        for(int i = 0; i < (charLength - 1); i++) {
            
            if(chars[i] != chars[i + 1]) {
                
                if(count > 1) {
                    
                    chars[writeIndex++] = chars[i];
                    
                    writeCount(count, chars);
                    
                    count = 1;
                    
                } else {
                    
                    chars[writeIndex++] = chars[i];
                    
                }
            } else {
                
                count++;
            }                 
        }
        
        if(count > 1) {
            
            chars[writeIndex++] = chars[charLength - 1];     
            
            writeCount(count, chars);           
            
        } else {
            
            chars[writeIndex++] = chars[charLength - 1];
        }
        
        return writeIndex;
        
    }
    
    public void writeCount(int count, char[] chars) {
        
        String countCharSeq = "" + count;
                    
        for(int j = 0; j < countCharSeq.length(); j++) {

            chars[writeIndex++] = countCharSeq.charAt(j);

        }
    }
    
}