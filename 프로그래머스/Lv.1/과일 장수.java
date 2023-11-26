import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        // 1,1,1,2,2,3,3
        
        for(int i = score.length; i >= m; i -= m) {
            if (i >= m) {
                answer += score[i - m] * m;
            }
        }
        
        return answer;
    }
    
    
}
