import java.util.*;
class Solution {
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    static String [][] board;
    // 1. 출발지점 -> 레버 찾기
    // 2. 레버 -> 출구 찾기
    // 3. 1거리 + 2거리 = 정답
    public int solution(String[] maps) {
        int m = maps.length; int n = maps[0].length();
        board = new String[m][n];
        int [] start = new int[2];
        int [] lever = new int[2];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                char ch = maps[i].charAt(j);
                board[i][j] = String.valueOf(ch);
                if (ch == 'S') {
                    start = new int[]{i,j};
                }
                if (ch == 'L') {
                    lever = new int[]{i,j};
                }
            }
        }
        int dist1 = bfs(start, "L");
        int dist2 = bfs(lever, "E");
        if (dist1 == -1 || dist2 == -1) return -1;
        return dist1 + dist2;
    }
    
    // start -> target 거리를 return
    public int bfs(int[] start, String target) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        int [][] dist = new int[board.length][board[0].length];
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()){
            int []cur = queue.poll();
            int x = cur[0]; 
            int y = cur[1];
            
            if (board[x][y].equals(target)) {
                return dist[x][y];
            }
            for(int dir = 0; dir < 4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                
                if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) continue;
                if (board[nx][ny].equals("X") || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                queue.add(new int[] {nx,ny});
            }
        }
        return -1;
    }
}