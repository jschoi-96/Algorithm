import java.util.*;
class Solution {
    char [][] board;
    boolean [][] visited;
    int [] dx = {1,0,-1,0};
    int [] dy = {0,1,0,-1};
    int n, m;
    List<Integer> res = new ArrayList<>();
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        board = new char[n][m];
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            String input = maps[i];
            for(int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j);
            }
        }
        
        Queue<int []> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (!visited[i][j] && board[i][j] != 'X') {
                    bfs(i,j);
                }
            }
        }
        
        if (res.isEmpty()) return new int[]{-1};
        
        Collections.sort(res);
        int[] answer = new int[res.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }
    
    public void bfs(int x, int y) {
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;
        
        int sum = board[x][y] - '0';
        
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int a = cur[0];
            int b = cur[1];
            for(int dir = 0; dir < 4; dir++) {
                int nx = a + dx[dir];
                int ny = b + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny] || board[nx][ny] == 'X') continue;
                sum += (board[nx][ny] - '0');
                q.add(new int[]{nx,ny});
                visited[nx][ny] = true;
            }
        }
        res.add(sum);
    }
}