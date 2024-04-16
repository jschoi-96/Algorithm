import java.util.*;
class Solution {
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int idx = 0;
        for(String [] place : places) {
            boolean flag = true;
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++) {
                    if (place[i].charAt(j) == 'P') {
                        if (!bfs(place, i, j)) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (!flag) break;
            }
            if (flag) answer[idx++] = 1;
            else answer[idx++] = 0;
        }
        
        return answer;
    }
    
    public boolean bfs(String[] place, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        
        boolean [][] visited = new boolean[5][5];
        visited[i][j] = true;
        
        while(!queue.isEmpty()) {
            int [] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            
            for(int dir = 0; dir < 4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || visited[nx][ny]) continue;
                
                int dist = Math.abs(nx - i) + Math.abs(ny - j);
                if (dist > 2) continue; // 거리가 2 이상일 땐 그냥 건너 뜀
                
                if (place[nx].charAt(ny) == 'P') {
                    return false;
                }
                
                else if (place[nx].charAt(ny) == 'O') {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny});
                }
            }
        }
        return true;
    }
}