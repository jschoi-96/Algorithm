import java.util.*;

class Solution {
    char [][] board;
    int n, m;
    int [] dx = {1,0,-1,0};
    int [] dy = {0,1,0,-1};

    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();
        
        // 🔹 board 배열 초기화
        board = new char[n][m];

        for(int i = 0; i < n; i++){
            String str = storage[i];
            for(int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        
        for(int i = 0; i < requests.length; i++) {
            String request = requests[i];
            char target = request.charAt(0);
            if (request.length() == 1) {
                jigae(target);
            }
            else crane(target);
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (board[i][j] != '.') answer++;
                //System.out.print(board[i][j]);
            }
            //System.out.println();
        }
        return answer;
    }
    
    public void jigae(char target) {
        boolean [][] visited = new boolean[n][m];
        Queue<int []> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            if (board[i][0] == '.' && !visited[i][0]) {
                visited[i][0] = true;
                q.add(new int[]{i,0});
            }
            if (board[i][m-1] == '.' && !visited[i][m-1]) {
                visited[i][m-1] = true;
                q.add(new int[]{i,m-1});
            }
        }
        
        for(int i = 0; i < m; i++) {
            if (board[0][i] == '.' && !visited[0][i]) {
                visited[0][i] = true;
                q.add(new int[]{0,i});
            }
            if (board[n-1][i] == '.' && !visited[n-1][i]) {
                visited[n-1][i] = true;
                q.add(new int[]{n-1, i});
            }
        }
        
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (board[nx][ny] == '.' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (board[i][j] == target) {
                    boolean isAccessible = false;
                    for(int dir = 0; dir < 4; dir++) {
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];
                        
                        // 가장자리 인 경우는 당연히 접근 가능
                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                            isAccessible = true;
                            break;
                        }
                        
                        // 인접칸이 빈칸이면서, 외부와 연결된 경우 접근 가능
                        if (board[nx][ny] == '.' && visited[nx][ny]) {
                            isAccessible = true;
                            break;
                        }
                    }
                    
                    // 접근 가능한 경우, 빈칸으로 만들어준다. 
                    if (isAccessible) {
                        board[i][j] = '.';
                    }
                }
            }
        }
    }
    
    public void crane(char target) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (board[i][j] == target) board[i][j] = '.';
            }
        }
    }
}