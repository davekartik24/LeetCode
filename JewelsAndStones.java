class Solution {
    public int numJewelsInStones(String J, String S) {
        
        if(J == null || S == null) return 0;
        
        boolean[] lookup = new boolean[256];
        
        int count = 0;
        
        for(int i = 0; i < J.length(); i++) {
            
            lookup[J.charAt(i)] = true;
        }
        
        for(int i = 0; i < S.length(); i++) {
            
            if(lookup[S.charAt(i)]) {
                count++;
            }
        }
        
        return count;
        
    }
}