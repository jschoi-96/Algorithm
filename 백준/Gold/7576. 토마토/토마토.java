import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int m, n;
    static int[][] board = new int[1002][1002];
    static int[][] dist = new int[1002][1002];
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) { // 토마토가 익은 경우 큐에 넣는다
                    queue.add(new int[] { i, j });
                }
                if (board[i][j] == 0) { // 익지 않은 경우는 -1로 초기화
                    dist[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                    continue;
                if (dist[nx][ny] >= 0)
                    continue; // 이미 방문했다면, 지나친다.
                dist[nx][ny] = dist[x][y] + 1;
                queue.add(new int[] { nx, ny });
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == -1) {
                    ans = -1;
                    System.out.println(-1);
                    return;
                }
                ans = Math.max(ans, dist[i][j]);
            }

        }
        System.out.println(ans);

    }
}
