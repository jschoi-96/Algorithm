class Solution {
    int [] dx = {1,0,-1,0};
    int [] dy = {0,1,0,-1};
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;

        Queue<int []> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int [][] heights = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    q.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            //System.out.println(x + " " + y);
            for(int dir = 0; dir < 4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny] || isWater[nx][ny] == 1) continue;

                heights[nx][ny] = heights[x][y] + 1;
                q.add(new int[]{nx,ny});
                visited[nx][ny] = true;
            }
        }
        return heights;
    }
}