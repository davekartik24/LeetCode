

class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        
        int totalInterval = 0;
        
        int[] taskCount = new int[26];
        
        for(char element : tasks) {
            
            taskCount[Character.toLowerCase(element) - 'a']++; 
        
        }
        
        Arrays.sort(taskCount);
        
        while(taskCount[25] != 0) {
            
            for(int i = 0; i <= n; i++) {
                
                if(taskCount[25] == 0) break;
                
                if(i < 26 && taskCount[25 - i] != 0) {
                    
                    taskCount[25 - i]--;
                }
                
                totalInterval++;
            }
            
            Arrays.sort(taskCount);
        }
        
        return totalInterval;
        
    }
}