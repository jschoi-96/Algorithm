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
        System.out.println("crane(" + c + ") 실행 후:");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (board[i][j] == c) board[i][j] = '.';
            }
        }
        print();
    }
    
    public void setEdge(char c) {
        for (int i = 0; i < n; i++) {
            if (board[i][0] == c) {
                board[i][0] = '.';
            }
            if (board[i][m - 1] == c) {
                board[i][m - 1] = '.';
            }
        }
        
        for (int j = 0; j < m; j++) {
            if (board[0][j] == c) {
                board[0][j] = '.';
            }
            if (board[n - 1][j] == c) {
                board[n-1][j] = '.';
            }
        }
    }
    
    public void zigae(char c) {
        // outside 배열 초기화
        setEdge(c);
        outside = new boolean[n][m];
        
        Queue<int[]> q = new LinkedList<>();
        // 외부 가장자리 탐색 (빈 공간만)
        for (int i = 0; i < n; i++) {
            if (board[i][0] == '.') {
                q.add(new int[]{i, 0});
                outside[i][0] = true;
            }
            if (board[i][m - 1] == '.') {
                q.add(new int[]{i, m - 1});
                outside[i][m-1] = true;
            }
        }
        
        for (int j = 0; j < m; j++) {
            if (board[0][j] == '.') {
                q.add(new int[]{0, j});
                outside[0][j] = true;
            }
            if (board[n - 1][j] == '.') {
                q.add(new int[]{n - 1, j});
                outside[n-1][j] = true;
            }
        }
        
        // 외부에서 접근 가능한 빈 공간들 찾기
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
                        
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (outside[nx][ny]) continue;
                
                // 빈 공간인 경우만 확산
                if (board[nx][ny] == '.') {
                    q.add(new int[]{nx, ny});
                    outside[nx][ny] = true;
                }
            }
        }
        
        // 외부 빈 공간과 인접한 해당 문자들 삭제
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (board[i][j] == c) {
                    // 상하좌우 중 하나라도 외부 빈 공간과 연결되어 있으면 삭제
                    boolean canDelete = false;
                    for(int dir = 0; dir < 4; dir++) {
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];
                        
                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                        if (outside[nx][ny]) {
                            canDelete = true;
                            break;
                        }
                    }
                    if (canDelete) {
                        board[i][j] = '.';
                    }
                }
            }
        }
        
        System.out.println("zigae(" + c + ") 실행 후:");
        print();
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
    
    public void print2() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(outside[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}