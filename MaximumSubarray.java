class Solution {
    public int maxSubArray(int[] nums) {
        
        if(nums.length == 0) return 0;
        
        int result = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++) {
            
            if(sum < 0) sum = 0;
            
            sum += nums[i];
            
            if(sum > result) {
                result = sum;
            }
        }
        
        return result;
        
    }
}