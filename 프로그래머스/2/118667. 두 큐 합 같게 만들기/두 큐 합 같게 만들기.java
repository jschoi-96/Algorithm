import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        // long 타입 고려!!!
        int len = queue1.length + queue2.length;
        
        long sum = 0;
        long q1Sum = 0;
        long q2Sum = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int queue: queue1) {
            sum += queue;
            q1Sum += queue;
            q1.add(queue);
        }
        for(int queue: queue2) {
            sum += queue;
            q2Sum += queue;
            q2.add(queue);
        }
        
        long half = sum / 2;
        
        int cnt = 0;
        for(int i = 0; i < len; i++) {
            if (q1Sum == q2Sum) {
                answer = cnt;
                break;
            }
            
            // q1의 합이 현재 총합의 반보다 큰 경우
            while(q1Sum > half) {
                // q1의 원소를 계속 덜어내서 q2에 붙여주고, q1의 합은 빼준다.
                int cur = q1.poll();
                q2.add(cur);
                q1Sum -= cur;
                q2Sum += cur;
                cnt++;
            }
            
            while(q2Sum > half) {
                int cur = q2.poll();
                q1.add(cur);
                q2Sum -= cur;
                q1Sum += cur;
                cnt++;
            }
        }
        
        
        return answer;
    }
}