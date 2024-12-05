class Solution {
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    public int orangesRotting(int[][] grid) {
        Queue<int []> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;

        boolean [][] visited = new boolean[n][m];
        int [][] time = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny] || grid[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                time[nx][ny] = time[x][y] + 1;
                res = Math.max(res, time[nx][ny]);
                q.add(new int[]{nx,ny});
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    res = -1;
                }
            }
        }
        return res;
    }
}