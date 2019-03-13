class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> countMap = new HashMap<>();
        
        for(int element : nums) {
            if(countMap.containsKey(element)) {
                countMap.put(element, countMap.get(element) + 1);
            } else {
                countMap.put(element, 1);
            }
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
            
            public int compare(Integer first, Integer second) {
                
                return countMap.get(first) - countMap.get(second);
            }
        });
        
        for(int element : countMap.keySet()) {
            
            pq.offer(element);
            
            if(pq.size() > k) {
                pq.poll();
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        while(!pq.isEmpty()) {
            
            result.add(0, pq.poll());
        }
         
        return result;
        
    }
}