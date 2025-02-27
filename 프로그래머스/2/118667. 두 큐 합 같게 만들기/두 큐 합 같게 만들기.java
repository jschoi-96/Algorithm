import java.util.*;
class Solution {
    // 원소 10^9 -> 합은 long 타입으로 받을 것 
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum = 0, q1Sum = 0, q2Sum = 0;
        for(int num : queue1) {
            q1.add(num);
            q1Sum += num;
        }
        
        for(int num : queue2) {
            q2.add(num);
            q2Sum += num;
        }
        
        long half = (q1Sum + q2Sum) / 2;
        //System.out.println(half);
        
        while(true) {
            if (answer > (queue1.length + queue2.length) * 2) return -1; // 한바퀴 돌았는데도 
            if (q1Sum == half) break;
            
            else if (q1Sum > half) {
                int num = q1.poll();
                q1Sum -= num;
                q2.add(num);
            }
            
            else {
                int num = q2.poll();
                q1Sum += num;
                q1.add(num);
            }
            answer++;
        }
        
        
        return answer;
    }
}