import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int currentServer = 0;
        
        // [종료 시간, 현재 서버 수]
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        
        for(int i = 0; i < 24; i++) {
            int people = players[i];
            
            if (people < m) continue;
            
            while(!pq.isEmpty() && pq.peek()[0] <= i) {
                int [] cur = pq.poll();
                currentServer -= cur[1];
            }
            
            int needServer = players[i] / m;
            int addServer = Math.max(0, needServer - currentServer); // 부족한 서버 수 
            //System.out.println("cur: " + currentServer +  " need: " + needServer + " addServer: " + addServer);
            if (addServer > 0) { // 부족한 서버만큼 서버 추가해야함.
                pq.add(new int []{i+k , addServer});
                currentServer += addServer; 
                answer += addServer;
            }       
            
        }
        
        return answer;
    }
}