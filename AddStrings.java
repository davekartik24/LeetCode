

class AddStrings {
    public String addStrings(String num1, String num2) {
        
        int num1Length = num1.length() - 1;
        int num2Length = num2.length() - 1;
        
        char[] num1CharArray = num1.toCharArray();
        char[] num2CharArray = num2.toCharArray();
        
        int carry = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while(num1Length >= 0 || num2Length >= 0) {
            
            
            int first = num1Length < 0 ? 0 : num1CharArray[num1Length--] - '0';
            int second = num2Length < 0 ? 0 : num2CharArray[num2Length--] - '0';
            
            sb.append((first + second + carry) % 10);
            carry = (first + second + carry) / 10;
            
        }
        
        if(carry > 0) sb.append(carry);
        
        return sb.reverse().toString();
        
    }
}