// Kartik's solution

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        int n = s.length();
        
        if((n * k) == 0) return 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        int left = 0;
        int right = 0;
        
        int max = 1;
        
        while(right < n) {
            
            map.put(s.charAt(right), right);
            
            if(map.size() == k + 1) {
                int leftIndex = Collections.min(map.values());
                map.remove(s.charAt(leftIndex));
                left = leftIndex + 1;
            }
            
            max = Math.max(max,right - left + 1);
            right++;
        }
        
        return max;
    }
}