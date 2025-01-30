import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int n = sequence.length;
        
        Arrays.sort(sequence);
        
        int lo = 0, hi = 0;
        long sum = 0;
        int len = Integer.MAX_VALUE;
        while(hi < n) {
            sum += sequence[hi++];
            
            while(sum > k) {
                sum -= sequence[lo++];
            }
            
            if (sum == k) {
                // System.out.println(lo + " " + hi);
                if (hi - lo < len) {
                    answer[0] = lo;
                    answer[1] = hi - 1;
                    len = hi - lo;
                }
            }
        }
        return answer;
    }
}