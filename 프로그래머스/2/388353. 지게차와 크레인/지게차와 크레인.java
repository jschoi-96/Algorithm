import java.util.*;
class Solution {
    int n, m;
    char[][] board;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[][] outside;
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();
        
        board = new char[n][m];
        outside = new boolean[n][m];
    
        for(int i = 0; i < n; i++) {
            String s = storage[i];
            for(int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        
        for (String request : requests) {
            char c = request.charAt(0);
            if (request.length() == 2) {
                crane(c);
            }
            
            else {
                zigae(c);
            }
            
        }
        
        // 결과 계산
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] != '.') {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    public void crane(char c) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (board[i][j] == c) board[i][j] = '.';
            }
        }
    }
    
    public void zigae(char c) {
        boolean[][] outside = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        // 1. 외부에서 부터 가장자리의 '.'을 모두 큐에 추가
        for(int i = 0; i < n; i++) {
            if (board[i][0] == '.') {
                q.add(new int[]{i, 0});
                outside[i][0] = true;
            }
            
            if (board[i][m-1] == '.') {
                q.add(new int[]{i, m-1});
                outside[i][m-1] = true;
            }
        }
        
        for(int i = 0; i < m; i++) {
            if (board[0][i] == '.') {
                q.add(new int[]{0, i});
                outside[0][i] = true;
            }
            
            if (board[n-1][i] == '.') {
                q.add(new int[]{n-1, i});
                outside[n-1][i] = true;
            }
        }
        
        // 2. 큐에 있는 좌표들을 순회하며 다음 지점이 외부와 연결되는지 체크
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (board[nx][ny] == '.' && !outside[nx][ny]) { // 컨테이너가 삭제되었고 외부와 연결되지 않았을 때
                    q.add(new int[]{nx, ny});
                    outside[nx][ny] = true;
                }
            }
        }
                
        // 3. 2차원 배열을 순회하며 외부의 노출된 컨테이너들을 제거해준다.
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                boolean flag = false;
                
                if (board[i][j] != c) continue;
                for(int dir = 0; dir < 4; dir++) {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];
                    
                    // 다음 좌표가 범위를 벗어낫다는 뜻은 현재 좌표가 가장자리 (외부와 연결됨)
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                        flag = true;
                        break;
                    }
                    
                    // 외부와 연결되어 있고, 컨테이너가 출고 된 경우 
                    if (outside[nx][ny] && board[nx][ny] == '.') {
                        flag = true;
                        break;
                    }
                }
                if (flag) board[i][j] = '.';
            }
        }
    }
    
    public void print() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}