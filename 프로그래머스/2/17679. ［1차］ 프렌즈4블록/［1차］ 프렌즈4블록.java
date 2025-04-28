import java.util.*;
class Solution {
    char[][] arr;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        arr = new char[m][n];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length(); j++) {
                arr[i][j] = board[i].charAt(j);
            }
        }
        
        while(true) {
            boolean flag = true;
            boolean [][] visited = new boolean[m][n];
            for(int i = 0; i < m - 1; i++) {
                for(int j = 0; j < n - 1; j++) {
                    if (arr[i][j] != '-' && isValid(i,j)) {
                        // System.out.println(i + " " + j);
                        erase(i, j, visited);
                        flag = false;
                    }
                }
            }
            
            if (flag) {
                System.out.println("?");
                int cnt = countBlocks(m, n);
                answer = cnt;
                break;
            }
            
            reset(visited, m, n);
            reArrange(m, n);
            // for(int i = 0; i < m; i++) {
            //     for(int j = 0; j < n; j++) {
            //         System.out.print(arr[i][j] + " ");
            //     }
            //     System.out.println();
            // }
        }
        return answer;
    }
    
    public boolean isValid(int x, int y) {
        return arr[x][y] == arr[x+1][y] && arr[x][y] == arr[x][y+1] && arr[x][y] == arr[x+1][y+1];
    }
    
    public void erase(int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        visited[x+1][y] = true;
        visited[x][y+1] = true;
        visited[x+1][y+1] = true;
    }
    
    public void reset(boolean[][] visited, int m, int n) {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (visited[i][j]) arr[i][j] = '-';
            }
        }
    }
    
    public void reArrange(int m, int n) {
        for(int j = 0; j < n; j++) {
            for(int i = m - 1; i >= 0; i--) {
                if (arr[i][j] == '-') {
                    int k = i - 1;
                    while(k >= 0 && arr[k][j] == '-') k--; // '-'가 등장하면 끝까지 탐색.
                    if (k >= 0) {
                        arr[i][j] = arr[k][j];
                        arr[k][j] = '-';
                    }
                }
            }
        }
    }
    
    public int countBlocks(int m, int n) {
        int cnt = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (arr[i][j] == '-') cnt++;
            }
        }
        return cnt;
    }
}