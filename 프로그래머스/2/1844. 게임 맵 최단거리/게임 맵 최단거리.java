import java.util.*;
class Solution {
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    public int solution(int[][] maps) {
        int answer = 0;
        int r = maps.length;
        int c = maps[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        boolean [][] visited = new boolean[r][c];
        int [][] dist = new int[r][c];
        
        q.add(new int[]{0,0});
        visited[0][0] = true;
        dist[0][0] = 1;
        
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if (maps[nx][ny] == 0 || visited[nx][ny]) continue;
                
                dist[nx][ny] = dist[x][y] + 1;
                q.add(new int[]{nx,ny});
                visited[nx][ny] = true;
                
            }
        }
        
        if (dist[r-1][c-1] == 0) dist[r-1][c-1] = -1;
        return dist[r-1][c-1];
    }
}