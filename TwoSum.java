import java.util.*;

class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
        
        int length = nums.length;
        
        for(int i = 0; i < length; i ++) {
            
            int diff = target - nums[i];
            
            if(memo.containsKey(diff)) {
                
                return new int[] {memo.get(diff), i};
                
            } else {
                
                memo.put(nums[i], i);
            }
        }
        
        return null;
        
    }
}