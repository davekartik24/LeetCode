class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        
        if(nums.length == 0) return 0;
        
        int maxIncrease = 1;
        
        int finalResult = 0;
        
        for(int i = 0; i < nums.length - 1; i++) {
            
            if(nums[i] < nums[i + 1]) {
                maxIncrease++;
            } else {
                finalResult = Math.max(finalResult, maxIncrease);
                maxIncrease = 1;
            }
    
        }
        
        return finalResult = Math.max(finalResult, maxIncrease);
        
    }
}