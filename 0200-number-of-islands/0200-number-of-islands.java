class Solution {
    static boolean [][] visited;
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        visited = new boolean[n][m];

        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    bfs(i,j, grid);
                    res++;
                }
            }
        }
        return res;
    }

    public void bfs(int i, int j, char[][] grid) {
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length) continue;
                if (visited[nx][ny] || grid[nx][ny] == '0') continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx,ny});
            }
        }
    }
}
