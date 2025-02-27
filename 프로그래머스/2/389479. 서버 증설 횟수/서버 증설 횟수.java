import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0] , b[0]));
        
        int currentServer = 0;
        for(int i = 0; i < players.length; i++) {
            if (players[i] < m) continue; // 사용자 m명 미만인 경우
            int needServer = players[i] / m;
            
            if (!pq.isEmpty() && pq.peek()[0] <= i) { // 
                int [] cur = pq.poll();
                currentServer -= cur[1];
            }
            
            int addServer = needServer - currentServer;
            if (currentServer < needServer) { // 서버 충원해야함.
                pq.add(new int[]{i + k, addServer});
                //System.out.println(needServer - currentServer);
                currentServer += addServer;
                answer += addServer;
            }

            
        }
        return answer;
    }
}