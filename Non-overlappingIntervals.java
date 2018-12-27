/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Non-overlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        
        if(intervals.length == 0) return 0;
        
        int overLappingCount = 0;
             
        Arrays.sort(intervals, new Comparator<Interval>() {
            
            public int compare(Interval obj1, Interval obj2) {
                
                if(obj2.end == obj1.end) return 0;
                
                if(obj1.end < obj2.end) return -1;
                
                return 1;
            }
        });
        
        int end = intervals[0].end;  
        
        for(int i = 1; i < intervals.length; i++) {
            
            if(intervals[i].start < end) {
                
                overLappingCount++;
            } else {
                
                end = intervals[i].end;
            }

        }
        
        return overLappingCount;
        
    }
    
}