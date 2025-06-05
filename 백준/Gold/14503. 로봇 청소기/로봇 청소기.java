import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        /*
        visited 청소 체크
            주변이 모두 방문처리된 경우 - 현재 방향을 유지하며 한칸 후진. 범위를 벗어난다면 작동 멈춤
            주변에 하나라도 청소되지 않은게 있는경우 - 반시계 방향으로 90도 회전(dir값에서 -1을 빼줌), 앞쪽 칸이 청소되지 않았다면 전진
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(r, c, d));
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        while(!q.isEmpty()) {
            Pos pos = q.poll();
            int x = pos.x;
            int y = pos.y;
            int cur_dir = pos.dir;

            if (!visited[x][y]) {
                visited[x][y] = true; // 현재 칸을 청소
                cnt++;
            }

            boolean flag = false;
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (board[nx][ny] == 0 && !visited[nx][ny]) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                while (true) {
                    cur_dir = (cur_dir + 3) % 4;
                    int nx = x + dx[cur_dir];
                    int ny = y + dy[cur_dir];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if (!visited[nx][ny] && board[nx][ny] == 0) {
                        q.add(new Pos(nx, ny, cur_dir));
                        break;
                    }
                }
            }

            else {
                int nxt_dir = (cur_dir + 2) % 4;
                int nx = x + dx[nxt_dir];
                int ny = y + dy[nxt_dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (board[nx][ny] == 1) {
                    System.out.println(cnt);
                    return;
                }

                q.add(new Pos(nx, ny, cur_dir));
            }
        }
    }

    static class Pos {
        int x;
        int y;
        int dir;
        public Pos(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
