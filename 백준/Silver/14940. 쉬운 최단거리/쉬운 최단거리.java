import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int [][] board;
    static int [][] dist;
    static boolean [][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n+1][m+1];
        dist = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (board[nx][ny] == 0 || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                q.add(new int[]{nx, ny});
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (board[i][j] == 1 && dist[i][j] == 0) System.out.print(-1 + " ");
                else System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
