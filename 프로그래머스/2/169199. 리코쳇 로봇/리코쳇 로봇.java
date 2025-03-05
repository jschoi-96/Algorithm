import java.util.*;
class Solution {
    // D나 가장자리에 도착할 때 방향이 바뀐다.
    char [][] arr;
    boolean [][] visited;
    int n, m;
    int [] dx = {1,0,-1,0};
    int [] dy = {0,1,0,-1};
    int answer = -1;
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        arr = new char[n][m];
        visited = new boolean[n][m];
        
        Queue<int []> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            String each = board[i];
            for(int j = 0; j < m; j++) {
                arr[i][j] = each.charAt(j);
                if (arr[i][j] == 'R') {
                    q.add(new int[]{i,j,0});
                }
            }
        }
        
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int moves = cur[2];
            
            if (arr[x][y] == 'G') {
                answer = moves;
            }
            
            for(int dir = 0; dir < 4; dir++) {
                int [] next = slide(x, y, dx[dir], dy[dir]);
                int nx = next[0];
                int ny = next[1];
                
                if (!visited[nx][ny]) {
                    q.add(new int[]{nx, ny, moves + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < m; j++) {
        //         System.out.print(visited[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        return answer;
    }
    
    public int[] slide(int x, int y, int dx, int dy) {
        while(x + dx >= 0 && x + dx < n && y + dy >= 0 && y + dy < m && arr[x+dx][y+dy] != 'D') {
            x += dx;
            y += dy;
        }
        return new int[]{x,y};
    }
}