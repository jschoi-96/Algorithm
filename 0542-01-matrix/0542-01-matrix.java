class Solution {
    int n, m;
    int [] dx = {1,0,-1,0};
    int [] dy = {0,1,0,-1};
    public int[][] updateMatrix(int[][] mat) {
        n = mat.length;
        m = mat[0].length;
        Queue<int []> q = new LinkedList<>();
        boolean [][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (mat[i][j] == 0) q.add(new int[]{i,j});
                else mat[i][j] = -1; // -1로 초기화 
            }
        }

        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            visited[x][y] = true;

            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny] || mat[nx][ny] == 0) continue;
                mat[nx][ny] = mat[x][y] + 1;
                visited[nx][ny] = true;
                q.add(new int[]{nx,ny});
            }
        }
        return mat;
    }
}