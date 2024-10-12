import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> {
            return Integer.compare(a[1], b[1]);
        });
        
        for(int [] target : targets) {
            pq.add(new int[]{target[0] , target[1]});
        }
        
        int before = 0;
        while(!pq.isEmpty()) {
            int [] cur = pq.poll();
            if (cur[0] >= before) {
                answer++;
                before = cur[1];
            }
        }
        return answer;
    }
}