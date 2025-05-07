import java.util.*;
class Solution {
    boolean[][] visited;
    int [] dx = {1,0,-1,0};
    int [] dy = {0,1,0,-1};
    int num = 0;
    int max = 0;
    public int[] solution(int m, int n, int[][] picture) {

        int[] answer = new int[2];
        visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    bfs(i,j,picture);
                    num++;
                }
            }
        }
        answer[0] = num;
        answer[1] = max;
        return answer;
    }
    
    public void bfs(int a, int b, int[][] picture) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});
        visited[a][b] = true;
        
        int area = 1;
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= visited.length || ny >= visited[0].length) continue;
                if (visited[nx][ny] || picture[nx][ny] != picture[x][y]) continue;
                
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
                area++;
            }
        }
        max = Math.max(max, area);
    }
}