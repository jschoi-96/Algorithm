class Solution {
    int n, m;
    int [] dx = {1,0,-1,0};
    int [] dy = {0,1,0,-1};
    int res = 0;
    boolean[][] visited;
    public int islandPerimeter(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        visited = new boolean [n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    visited[i][j] = true;
                    bfs(i,j,grid);
                }
            }
        }
        return res;
    }
    
    public void bfs(int x, int y, int[][] grid) {
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{x,y});
        
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int a = cur[0];
            int b = cur[1];

            int cnt = 0;
            for(int dir = 0; dir < 4; dir++) {
                int nx = a + dx[dir];
                int ny = b + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (grid[nx][ny] == 1) {
                    cnt++;
                }
                if (visited[nx][ny] || grid[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx,ny});
            }
            // System.out.println("좌표: " + a + " " + b + " cnt: " + cnt);
            res += 4 - cnt;
        }
    }
}