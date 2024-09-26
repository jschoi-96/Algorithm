import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int st = 1, en = 200000000;
        
        while(st <= en) {
            int mid = st + (en - st) / 2;
            // System.out.println("mid: " + mid);
            
            int max = 0;
            int len = 1;
            for(int i = 0; i < stones.length; i++) {
                if (stones[i] <= mid) {
                    len++;
                }
                
                else {
                    len = 1;
                }
                max = Math.max(max, len);
            }
            // System.out.println("max: " + max);

            if (max <= k) {
                st = mid + 1;
            }
            
            else {
                en = mid - 1;
            }
            
        }
        
        return st;
    }
}