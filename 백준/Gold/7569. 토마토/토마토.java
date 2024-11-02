import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m, n, h;
    static int [][][] board;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int max_day = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        board = new int[h][n][m];
        visited = new boolean[h][n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < m; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    if (board[i][j][k] == 1) {
                        q.add(new int[]{i, j, k, 0});
                    }
                }
            }
        }

        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int z = cur[2];
            int day = cur[3];
            for(int dir = 0; dir < 6; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                int nz = z + dz[dir];
                if (nx < 0 || ny < 0 || nz < 0 || nx >= h || ny >= n || nz >= m) continue;
                if (visited[nx][ny][nz] || board[nx][ny][nz] != 0) continue;
                visited[nx][ny][nz] = true;
                // System.out.println(day);
                max_day = Math.max(max_day, day);
                q.add(new int[]{nx, ny, nz, day + 1});
            }
        }

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if (board[i][j][k] == 0 && !visited[i][j][k]) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        if (max_day == 0) System.out.println(0);
        else System.out.println(max_day + 1);
    }
}
