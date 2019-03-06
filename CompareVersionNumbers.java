class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        
        int length = Math.min(version1Array.length, version2Array.length);

        for(int i = 0; i < length; i++) {
            
            int first = Integer.parseInt(version1Array[i]);
            int second = Integer.parseInt(version2Array[i]);
            
            if(first > second) {
                
                return 1;
            } else if(first < second) {
                return -1;
            }
        }
        
        if(version1Array.length > length) {
            
            for(int i = version2Array.length; i < version1Array.length; i++) {
                if(Integer.parseInt(version1Array[i]) > 0) {
                    return 1;
                }
            }
            
        } else if(version2Array.length > length) {
            for(int i = version1Array.length; i < version2Array.length; i++) {
                if(Integer.parseInt(version2Array[i]) > 0) {
                    return -1;
                }
            }
            
        }
        
        return 0;
    }
}