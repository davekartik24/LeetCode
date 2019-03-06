class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        
        int slow = nums[0];
        int fast = nums[slow];
        
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]]; 
        }
        
        int ptrOne = 0;
        int ptrTwo = slow;
        
        while(ptrOne != ptrTwo) {
            
            ptrOne = nums[ptrOne];
            ptrTwo = nums[ptrTwo];
        }
        
        return ptrOne;
    } 
}