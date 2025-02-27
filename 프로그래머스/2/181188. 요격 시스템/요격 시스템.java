import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        
        Arrays.sort(targets , (a,b) -> a[1] - b[1]);
        
        int before = 0;
        for(int [] target : targets) {
            int s = target[0];
            int e = target[1];
            
            if (before <= s) { // 시작점보다 같
                before = e;
                answer++;
                //System.out.println(s + " " + e);
            }
            // System.out.println(s + " " + e);
        }
        
        return answer;
    }
}