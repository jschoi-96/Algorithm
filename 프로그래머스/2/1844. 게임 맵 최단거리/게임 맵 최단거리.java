import java.util.*;
class Solution {
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    public int solution(int[][] maps) {
        int n = maps.length; int m = maps[0].length;
        int [][] dist = new int[n][m];
        boolean [][] visited = new boolean[n][m];
        
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{0,0});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int dir = 0; dir < 4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (maps[nx][ny] == 0 || visited[nx][ny]) continue;
                
                dist[nx][ny] = dist[x][y] + 1;
                visited[nx][ny] = true;
                q.add(new int[]{nx,ny});
            }
        }
        if (dist[n-1][m-1] == 0) return -1;
        return dist[n-1][m-1] + 1;
    }
}