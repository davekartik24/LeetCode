public class CountAndSay {
    
    public String countAndSay(int n) {
        
        int i = 1;
        String s = "1";
        
        while(i < n) {
            
            int sCount = s.length();
            int j = 0;
            Character c = s.charAt(0);
            int count = 0;
            StringBuilder sb = new StringBuilder();
            
            while(j < sCount) {
                
                if(c == s.charAt(j)) {
                    
                    ++count;
                    
                } else {

                    sb.append(count);
                    sb.append(c);
                    c = s.charAt(j);
                    count = 1;
                }

                ++j;
                
            }

            sb.append(count);
            sb.append(c);
            
            s = sb.toString();
            ++i;
            
        }
        
        return s;
        
    }

}