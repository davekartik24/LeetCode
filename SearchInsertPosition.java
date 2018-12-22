class Solution {
    public int searchInsert(int[] nums, int target) {
        
        if(nums.length == 0) return 0;
        
        int i = 0;
        
        while(i < nums.length && nums[i] < target) {
            
            i++;
        }
        
        return i;
    }
}