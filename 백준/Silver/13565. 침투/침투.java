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
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] board = new int[m][n];
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 0 && !visited[0][i]) {
                visited[0][i] = true;
                q.add(new int[]{0, i});
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int x = cur[0];
                    int y = cur[1];

                    if (x == m - 1) {
                        System.out.println("YES");
                        return;
                    }

                    for(int dir = 0; dir < 4; dir++) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                        if (visited[nx][ny] || board[nx][ny] == 1) continue;

                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        System.out.println("NO");
    }
}
