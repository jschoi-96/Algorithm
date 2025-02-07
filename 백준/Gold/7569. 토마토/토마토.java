import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m,n,h;
    static int [][][] board;
    static int [][][] dist;
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        board = new int[h][n][m];
        dist = new int[h][n][m];
        Queue<int []> q = new LinkedList<>();

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < m; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    if (board[i][j][k] == 1) {
                        q.add(new int[] {i, j, k});
                        dist[i][j][k] = 0;
                    }
                    else dist[i][j][k] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int z = cur[2];
            for(int dir = 0; dir < 6; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                int nz = z + dz[dir];
                if (nx < 0 || ny < 0 || nz < 0 || nx >= h || ny >= n || nz >= m) continue;
                if (dist[nx][ny][nz] != -1 || board[nx][ny][nz] != 0) continue;
                dist[nx][ny][nz] = dist[x][y][z] + 1;
                q.add(new int[] {nx, ny, nz});
            }
        }

        int max_dist = -1;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if (board[i][j][k] == 0 && dist[i][j][k] == -1) {
                        System.out.println(-1);
                        return;
                    }
                    max_dist = Math.max(max_dist, dist[i][j][k]);
                }
            }
        }
        System.out.println(max_dist);
    }
}
