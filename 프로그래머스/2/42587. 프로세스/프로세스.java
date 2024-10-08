import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> {
            return Integer.compare(b[1], a[1]);
        });
        
        for(int i = 0; i < priorities.length; i++) {
            q.add(new int[]{i, priorities[i]});
            pq.add(new int[]{i, priorities[i]});
        }
        
       
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            
            if (pq.peek()[1] > cur[1]) {
                q.add(cur);
            }
            
            else {
                if (cur[0] == location) {
                    return answer;
                }
                pq.poll();
                answer++;
            }
            
            
        }
        
        return answer;
    }
}