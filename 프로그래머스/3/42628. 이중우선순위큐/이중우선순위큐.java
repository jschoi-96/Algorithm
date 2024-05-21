import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> min_pq = new PriorityQueue<>();
        PriorityQueue<Integer> max_pq = new PriorityQueue<>(Collections.reverseOrder());
        // max : 16 5643
        // min : 5643 16
        for(String operation : operations) {
            String [] str = operation.split(" ");
            String order = str[0];
            int num = Integer.parseInt(str[1]);
            if (order.equals("I")) {
                min_pq.add(num);
                max_pq.add(num);
            }
            
            else if (order.equals("D")) {
                if (num == -1 && !min_pq.isEmpty()) { // 최솟값 삭제
                    max_pq.remove(min_pq.poll());
                }
                
                else if (num == 1 && !max_pq.isEmpty()) { // 최댓값 삭제
                    min_pq.remove(max_pq.poll());
                }
            }
        }
        
        answer[0] = max_pq.isEmpty() ? 0 : max_pq.poll();
        answer[1] = min_pq.isEmpty() ? 0 : min_pq.poll();
        return answer;
    }
    // min:  97, 333, 653
    // max: 45, 97, 333
}