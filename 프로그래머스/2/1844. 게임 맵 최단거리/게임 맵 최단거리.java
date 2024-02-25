import java.util.*;
class Solution {
    Queue<int []> q = new LinkedList<>();
    
    int [] dx = {1,0,-1,0};
    int [] dy = {0,1,0,-1};
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int [][] dist = new int[n+2][m+2];
        dist[0][0] = 1; // 처음 시작점을 1으로 설정 
        q.add(new int[]{0,0});
        
        while(!q.isEmpty()){
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int dir = 0; dir < 4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (maps[nx][ny] == 0 || dist[nx][ny] != 0) continue;
                
                dist[nx][ny] = dist[x][y] + 1;
                q.add(new int[]{nx,ny});
            }
        }

        if (dist[n-1][m-1] == 0) return -1;
        return dist[n-1][m-1];
    }
}