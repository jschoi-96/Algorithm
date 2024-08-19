import java.util.*;
class Solution {
    public long solution(int n, int[] times) {        
        long max = 0;
        for(int t : times) if (t > max) max = t;
        
        long lo = 1;
        long hi = max * n; // 최댓값;
        
        while(lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            
            long total = 0;
            for(int time : times) {
                total += (mid / time);
            }
            
            
            if (total < n) { // 한명의 사람을 더 받을 수 있기 때문에 mid값을 키워서 
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        
        return lo;
    }
}