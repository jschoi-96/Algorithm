import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        // [1,4]
        // [3,7], [4,5], [4,8] 
        // [5,12], [10,14], [11,13]
        
        Arrays.sort(targets, (a,b) -> a[1] - b[1]);
        int before = 0;
        for(int [] target : targets) {
            
            if (before > target[0]) continue; // 미사일 시작점보다 이전 값이 크다면, 포함된다는 뜻
            before = target[1]; //
            answer++;
            System.out.println(target[0] + " " + target[1]);
        }
        return answer;
    }
}