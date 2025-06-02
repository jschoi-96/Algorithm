import java.util.*;
class Solution {
    // request -> 100, 2500 * 100 
    static char[][] board;
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Set<Character> set = new HashSet<>();
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();
        
        board = new char[n][m];
        for(int i = 0; i < n; i++) {
            String input = storage[i];
            for(int j = 0; j < input.length(); j++) {
                board[i][j] = input.charAt(j);
                set.add(board[i][j]);
            }
        }
        
        for(String request : requests) {
            char c = request.charAt(0);
            if (!set.contains(c)) continue;
            
            if (request.length() == 1) { // 지게차를 이용하여 외부 및 접근 가능한 것만 출고 
                // 어떻게 외부를 판단? 
                zigae(c);
            }
            
            else { // 크레인을 사용하여 일치하는 문자를 모두 제거 
                crane(c);
            }
            
            printBoard();
        }
        return printBoard();
    }
    
    public void zigae(char target) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        checkEdge(q, visited);
        bfs(q, visited);
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                
                if (board[i][j] == target) {
                    boolean isPossible = false;
                    for(int dir = 0; dir < 4; dir++) {
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];
                        
                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                            isPossible = true;
                            break;
                        }
                        if (board[nx][ny] == '0' && visited[nx][ny]) {
                            isPossible = true;
                            break;
                        }
                    }
                    
                    if (isPossible) board[i][j] = '0';
                }
            }
        }
    }
    
    public void bfs(Queue<int[]> q, boolean[][] visited) {
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (board[nx][ny] == '0' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
                
    public void checkEdge(Queue<int[]> q, boolean[][] visited) {
        for(int i = 0; i < m; i++) {
            if (board[0][i] == '0' && !visited[0][i]) {
                visited[0][i] = true;
                q.add(new int[]{0,i});
            }
            
            if (board[n-1][i] == '0' && !visited[n-1][i]) {
                visited[n-1][i] = true;
                q.add(new int[]{n-1, i});
            }
        }
        
        for(int i = 0; i < n; i++) {
            if (board[i][0] == '0' && !visited[i][0]) {
                visited[i][0] = true;
                q.add(new int[]{i, 0});
            }
            
            if (board[i][m-1] == '0' && !visited[i][m-1]) {
                visited[i][m-1] = true;
                q.add(new int[]{i, m-1});
            }
        }
    }
    
    public void crane(char target) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (board[i][j] == target) board[i][j] = '0';
            }
        }
    }
    
    public int printBoard() {
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                //System.out.print(board[i][j]);
                if (board[i][j] != '0') cnt++;
            }
            //System.out.println();
        }
        //System.out.println();
        return cnt;
    }
}