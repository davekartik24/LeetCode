class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        paragraph = paragraph + ".";
        int max = 0;
        String result = "";
        
        HashSet<String> bannedSet = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String element : banned) {
            bannedSet.add(element);
        }
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        
        while(i < paragraph.length()) {
            
            if(Character.isLetter(paragraph.charAt(i))){
                sb.append(Character.toLowerCase(paragraph.charAt(i)));
            } else {
                if(sb.length() > 0) {
                    String word = sb.toString();
                    
                    if(!bannedSet.contains(word)) {
                        
                        if(map.containsKey(word)) {
                            map.put(word, map.get(word) + 1);
                        } else {
                            map.put(word, 1);
                        }
                    }
                }
                
                sb = new StringBuilder();
                
            }
            
            i++;
        }
        
        for(Map.Entry<String, Integer> mapElement : map.entrySet()) {
            
            if(mapElement.getValue() > max) {
                max = mapElement.getValue();
                result = mapElement.getKey();
            }
        }
        
        return result;
        
    }
}