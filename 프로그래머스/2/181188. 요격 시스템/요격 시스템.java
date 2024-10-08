import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (a,b) -> a[1] - b[1]);
        
        int before = 0;
        for(int [] target : targets) {
            // System.out.println(target[0] + " " + target[1]);
            if (before <= target[0]) {
                before = target[1];
                answer++;
            }
        }
        
        // [1,4]
        // [3,7] [4,5] [4,8]
        // [5,12] [10,14] [11,13]
        return answer;
    }
}