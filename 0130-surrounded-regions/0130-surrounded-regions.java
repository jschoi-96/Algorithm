class Solution {
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean [][] visited = new boolean[n][m];
        // 1. 가장자리를 제외하고 O인 부분에서 BFS 돌린다.
        for(int i = 1; i < n-1; i++){ 
            for(int j = 1; j < m-1; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    bfs(i,j,board,visited);
                }
            }
        }

        for(int i = 1; i < n - 1; i++) {
            for(int j = 1; j < m - 1; j++) {
                if (board[i][j] == 'O' && visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void bfs(int i, int j, char[][] board, boolean[][] visited) {
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;

        boolean flag = false;

        List<int []> tmp = new ArrayList<>();

        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            tmp.add(cur);

            if (x == 0 || y == 0 || x == board.length - 1 || y == board[0].length - 1) {
                flag = true;
            }

            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) continue;
                if (visited[nx][ny] || board[nx][ny] == 'X') continue;

                System.out.println("nx: " + nx + " ny: " + ny);
                q.add(new int[]{nx,ny});
                visited[nx][ny] = true;
            }
        }

        if (flag) {
            for(int [] tmps : tmp) {
                visited[tmps[0]][tmps[1]] = false;
            }
        }
    }
}
