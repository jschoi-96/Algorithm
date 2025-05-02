import java.util.*;
class Solution {
    
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int idx = 0;
        // 2차원 char 형태로 변환.
        for(String [] place : places) {
            
            boolean flag = true;
            char[][] board = new char[5][5];
            for(int i = 0; i < 5; i++) {
                board[i] = place[i].toCharArray();
            }
            
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    if (board[i][j] == 'P') {
                        if (!bfs(board,i,j)) {
                            flag = false;
                            //break;
                        }
                    }
                }
            }
            
            if (flag) answer[idx] = 1;
            else answer[idx] = 0;
            idx++;
        }
        return answer;
    }
    
    public boolean bfs(char[][] board, int a, int b) {
        boolean[][] visited = new boolean[5][5];
        visited[a][b] = true;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a,b,0});
        
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            
            if (dist >= 2) continue;
            
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if (visited[nx][ny] || board[nx][ny] == 'X') continue;
                
                if (dist <= 2 && board[nx][ny] == 'P') return false;
                
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, dist + 1});
            }
        }
        return true;
    }
}