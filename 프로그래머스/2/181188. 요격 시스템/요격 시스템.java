import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (a,b) -> a[1] - b[1]);
        int before = 0;
        for(int [] target : targets) {
            
            if (before > target[0]) continue; 
            before = target[1]; 
            System.out.println(before);
            answer++;
        }
        return answer;
    }
}