class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] A) {
        
        if(A.length == 0) return 0;
        
        int stringLength = A[0].length();
        
        if(stringLength == 0) return 0;
        
        int deletionCount = 0;
        
        for(int i = 0; i < stringLength; i++) {
            
            for(int j = 0; j < A.length - 1; j++) {
                
                if(A[j].charAt(i) > A[j+1].charAt(i)) {
                    
                    deletionCount++;
                    break;
                }
            }
        }
        
        return deletionCount;
        
    }
}