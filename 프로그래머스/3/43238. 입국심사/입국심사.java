import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        long min = 1;
        long max = times[times.length - 1] * (long)n;
        
        while (min <= max) {
            long mid = (min + max) / 2; // 시간 
            long tmp = 0;
            
            for(int i = 0; i < times.length; i++) {
                tmp += (mid / times[i]);
            }
           
            if (tmp >= n) {
                max = mid - 1;
                answer = mid;
                //System.out.println(mid);
            }
            else min = mid + 1;
                        
        }        
        return answer;
    }
}