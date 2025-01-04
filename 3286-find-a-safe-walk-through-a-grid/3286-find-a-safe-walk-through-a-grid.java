class Solution {
    // (0,0)에서 (m-1,n-1)까지 출발
    // health값이 주어지고, 칸이 1을 밟으면 health - 1. 
    // 최종점에서 health가 1이상이면 true, 아니라면 false를 반환.

    int [][] board;
    int [][] val;
    int [] dx = {1,0,-1,0};
    int [] dy = {0,1,0,-1};
    int n, m;
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        n = grid.size();
        m = grid.get(0).size();

        board = new int[n][m];
        val = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < grid.get(i).size(); j++) {
                board[i][j] = grid.get(i).get(j);
            }
        }

        if (board[0][0] == 1) val[0][0] = health - 1;
        else val[0][0] = health;
        
        bfs(health);

        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < m; j++) {
        //         System.out.print(val[i][j] + " ");
        //     }
        //     System.out.println();
        // }

    
        return val[n-1][m-1] >= 1;
    }

    public void bfs(int health) {
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            int nxtHealth = 0;
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                int tmp_val = 0;
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                
                // 다음 지점이 1이라면, 현재값 -1
                if (board[nx][ny] == 1) nxtHealth = val[x][y] - 1;
                else nxtHealth = val[x][y]; 

                if (nxtHealth < 1) continue;
                if (nxtHealth > val[nx][ny]) {
                    val[nx][ny] = nxtHealth;
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }
}