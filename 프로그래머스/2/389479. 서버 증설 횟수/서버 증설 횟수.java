import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int currentServer = 0;
        PriorityQueue<int[] > pq = new PriorityQueue<>((a,b) -> {
           return a[1] - b[1]; // 종료시간이 빠른 순서대로 pop 
        });
        
        for(int i = 0; i < players.length; i++) {
            
            int needServer = players[i] / m;
            
            if (!pq.isEmpty() && pq.peek()[1] == i) {
                currentServer -= pq.poll()[0];
            }
            
            int addServer = needServer - currentServer;
            if (currentServer < needServer) { // 서버를 추가 증설해야 하는 경우 
                pq.add(new int[]{addServer, i + k});
                currentServer += addServer;
                answer += addServer;
            }
        }
        return answer;
    }
}