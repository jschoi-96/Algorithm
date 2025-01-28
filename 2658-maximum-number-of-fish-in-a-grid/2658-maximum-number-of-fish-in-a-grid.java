class Solution {
    int [] dx = {1,0,-1,0};
    int [] dy = {0,1,0,-1};
    int n, m;
    boolean [][] visited;
    int res = 0;
    public int findMaxFish(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] != 0) {
                    bfs(i,j,grid);
                }
            }
        }
        return res;
    }

    public void bfs(int i, int j, int[][] grid) {
        visited[i][j] = true;
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{i,j});

        int area = grid[i][j];
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny] || grid[nx][ny] == 0) continue;
                area += grid[nx][ny];
                visited[nx][ny] = true;
                q.add(new int[]{nx,ny});
            }
        }
        res = Math.max(res, area);
        // System.out.println(area);
    }
}