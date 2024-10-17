import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs , (a,b) -> (a[0] - b[0])); // 요청되는 순서로 정렬
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> (a[1] - b[1])); // 소요시간 순서대로 정렬
        
        
       
        int count = 0;
        int idx = 0;
        int end = 0;
        int total = 0;
        int n = jobs.length; 
       
        while (count < n) {
            
            while(idx < n && jobs[idx][0] <= end) { // 현재 시간보다 작거나 같은 값을 우큐에 추가
                pq.add(jobs[idx]);
                idx++;
            }
            
            if (!pq.isEmpty()) { //
                int [] cur = pq.poll();
                end += cur[1]; // 끝나는 시간을 더해준다.
                total += end - cur[0]; // 
                count++;
                System.out.println(total);
            }
            
            else { 
                end = jobs[idx][0];
            }
        }
  
        return total/count;
    }
}