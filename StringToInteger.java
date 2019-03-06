class StringToInteger {
    public int myAtoi(String str) {
        
        int result = 0;
        
        char[] inputArray = str.toCharArray();
        
        for(int i = 0; i < inputArray.length; i++) {
            
            if(inputArray[i] == ' ' || inputArray[i] == '-' || inputArray[i] == '+' || (inputArray[i] >= '0' && inputArray[i] <= '9')) {
                if(inputArray[i] == ' ') {
                    continue;
                } else {
                    return findTheNumber(inputArray, i);
                }
                
                
            } else {
                
                return 0;
            }
        }
        
        return 0;
    }
    
    public int findTheNumber(char[] inputArray, int i) {
        
        long result = 0;
        StringBuilder sb = new StringBuilder();
        
        if(inputArray[i] == '-'){
            sb.append(inputArray[i]);
            i++;
        } else if(inputArray[i] == '+') {
            i++;
        }
        
        while(i < inputArray.length && inputArray[i] == '0') {
            i++;
        }
    
        for(int start = i; start < inputArray.length; start++) {
            
            if(inputArray[start] >= '0' && inputArray[start] <= '9') {
                
                sb.append(inputArray[start]);
            } else {
                break;
            }
            
        }
        
        String finalString = sb.toString();
        
        if(finalString.length() > 17) {
            
            finalString = finalString.substring(0, 17);
        }
        
        if(finalString.equals("") || finalString.equals("-")) {
            return 0;
        } else {
            result = Long.parseLong(finalString);
        }
        
        
        if(result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        
        return (int)result;
    }
}