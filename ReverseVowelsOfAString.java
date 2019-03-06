class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        
        boolean[] vowelsLookup = new boolean[256];
        char[] sArray = s.toCharArray();
        
        vowelsLookup['a'] = true;
        vowelsLookup['e'] = true;
        vowelsLookup['i'] = true;
        vowelsLookup['o'] = true;
        vowelsLookup['u'] = true;
        vowelsLookup['A'] = true;
        vowelsLookup['E'] = true;
        vowelsLookup['I'] = true;
        vowelsLookup['O'] = true;
        vowelsLookup['U']  = true;
        
        int i = 0;
        int j = s.length() - 1;
        
        while(i < j) {
            
            if(vowelsLookup[sArray[i]] == true && vowelsLookup[sArray[j]] == true) {
                char temp = sArray[i];
                sArray[i++] = sArray[j];
                sArray[j--] = temp;
            } else if(vowelsLookup[sArray[i]] == true) {
                j--;
            } else if(vowelsLookup[sArray[j]] == true) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        
        return new String(sArray);
    }
}