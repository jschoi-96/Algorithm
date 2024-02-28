import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] board = new int[502][502];
    static boolean[][] visited = new boolean[502][502];
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int area = 0;
    static int res = 0;
    static int num = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == 0 || visited[i][j] == true)
                    continue;
                visited[i][j] = true;
                queue.add(new int[] { i, j });

                while (!queue.isEmpty()) {
                    area++;
                    int[] cur = queue.poll();
                    int x = cur[0];
                    int y = cur[1];

                    for (int dir = 0; dir < 4; dir++) { // 4방향을 돌면서 체크
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                            continue;
                        if (board[nx][ny] == 0 || visited[nx][ny] == true)
                            continue;

                        queue.add(new int[] { nx, ny });
                        visited[nx][ny] = true;
                    }

                }
                res = Math.max(res, area);
                area = 0;
                num++;
            }
        }
        System.out.println(num);
        System.out.println(res);

    }
}
