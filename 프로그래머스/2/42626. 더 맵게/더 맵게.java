import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for(long s : scoville) pq.add(s);
        
        if (pq.peek() >= K) return answer;
        
        while(!pq.isEmpty()) {
            long num1 = pq.poll();
            
            if (!pq.isEmpty()) {
                long num2 = pq.poll();
                long newFood = num1 + num2 * 2;
                pq.add(newFood);
                answer++;

                if (pq.peek() >= K) {
                    return answer;
                }
            }
        }
        
        return -1;
    }
}