class Solution {
    boolean [][] visited1;
    boolean [][] visited2;
    int n, m;
    int [] dx = {1,0,-1,0};
    int [] dy = {0,1,0,-1};
    int cnt = 0;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n = grid1.length;
        m = grid1[0].length; // grid1 == grid2 length

        visited1 = new boolean[n][m];
        visited2 = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (!visited2[i][j] && grid1[i][j] == 1 && grid2[i][j] == 1) {
                    bfs(i,j, grid1, grid2);
                }
            }
        }
        return cnt;
    }

    public void bfs(int i, int j, int[][] grid1, int [][] grid2) {
        System.out.println("start: " + i + " " + j);
        visited2[i][j] = true;
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{i,j});

        boolean flag = true;
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if (grid1[x][y] == 0) { // 연결된 곳의 grid1 좌표가 없다면 break
                //visited2[x][y] = true;
                System.out.println(x + " " + y);
                flag = false;
            }

            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited2[nx][ny] || grid2[nx][ny] == 0) continue;

                visited2[nx][ny] = true;
                q.add(new int[]{nx,ny});
            }
        }

        if (flag) {
            cnt++;
        }
    }
}