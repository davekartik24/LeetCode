class ReverseStringII {
    public String reverseStr(String s, int k) {
        
        char[] input = s.toCharArray();
        
        int i = 0;
        int j = k - 1;
        
        while(i < input.length) {
            
            reverse(input, i , j);
            i = i + (2 * k);
            j = i + k - 1;
        }
        
        return new String(input);
    }
    
    public void reverse(char[] input, int start, int end) {
        
        if(end > input.length - 1) {
            end = input.length - 1;
        }
        
        while(start < end) {
            
            char temp = input[start];
            input[start++] = input[end];
            input[end--] = temp;
        }
    }
}