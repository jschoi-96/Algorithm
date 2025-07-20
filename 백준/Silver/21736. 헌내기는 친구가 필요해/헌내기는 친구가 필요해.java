import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'I') {
                    q.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny] || board[nx][ny] == 'X') continue;

                if (board[nx][ny] == 'P') cnt++;
                visited[nx][ny] = true;
                q.add(new int[] {nx, ny});
            }
        }

        if (cnt == 0) System.out.println("TT");
        else System.out.println(cnt);
    }
}
