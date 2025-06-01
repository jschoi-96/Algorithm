import java.util.*;
class Solution {
    static int n;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int min_cost = Integer.MAX_VALUE;
    public int solution(int[][] board) {
        int answer = 0;
        n = board.length;
        
        bfs(0, board);
        bfs(1, board);
        
        return min_cost;
    }
    
    public void bfs(int direction, int[][] board) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, direction, 0));
        
        int[][] visited = new int[n][n];
        visited[0][0] = 100;
        
        while(!q.isEmpty()) {
            Point cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int curDir = cur.dir;
            int cost = cur.cost;
            
            if (x == n - 1 && y == n - 1) {
                //System.out.println(cost);
                min_cost = Math.min(min_cost, cost);
                continue;
            }
            
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (board[nx][ny] == 1) continue;
                
                int nextCost = 0;
                if (curDir == dir) nextCost = cost + 100;
                else nextCost = cost + 600;
                
                if (visited[nx][ny] == 0 || nextCost < visited[nx][ny]) {
                    visited[nx][ny] = nextCost;
                    q.add(new Point(nx, ny, dir, nextCost));
                }
            }
        }
    }
    
    public class Point {
        int x;
        int y;
        int dir;
        int cost;
        public Point(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
}