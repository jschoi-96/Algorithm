class Solution {
    static boolean [][] visited;
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        visited = new boolean[n][m];
        int max_area = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = bfs(i,j,grid);
                    max_area = Math.max(max_area, area);
                }
            }
        }
        return max_area;
    }

    public int bfs(int i, int j, int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        q.add(new int[]{i,j});

        int area = 0;
        while(!q.isEmpty()) {
            area++;
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length) continue;
                if (visited[nx][ny] || grid[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                q.add(new int []{nx,ny});
                System.out.println(area);
            }
        }
        //System.out.println(area);
        return area;
    }
}
