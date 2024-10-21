import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int [][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        boolean [][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 0이 존재하는 모든곳에 조합으로 벽을 다 세워본다.

//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < m; j++) {
//                if (board[i][j] == 0) { // visited 체크 해야하나?
//                    dfs(i,j, 1, temp, visited);
//                    // break;
//                }
//            }
//        }
        dfs(0);
        System.out.println(max);
    }

    public static void dfs(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;
                    dfs(depth + 1);
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        int [][] temp = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                temp[i][j] = board[i][j];
            }
        }

        Queue<int []> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (temp[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (temp[nx][ny] == 0) {
                    temp[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        int cnt = count(temp);
        max = Math.max(cnt, max);
    }

    public static int count(int [][] temp) {
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (temp[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
}
