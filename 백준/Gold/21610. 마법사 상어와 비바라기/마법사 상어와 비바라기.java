import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] board;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<int[]> clouds = new ArrayList<>();
        clouds.add(new int[]{n-1, 0});
        clouds.add(new int[]{n-1, 1});
        clouds.add(new int[]{n-2, 0});
        clouds.add(new int[]{n-2, 1});

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            List<int[]> nextClouds = moveCloud(d, s, clouds);
            checkWater(nextClouds);
            makeCloud(clouds, nextClouds);
            // break;
        }
        cal();
        System.out.println(res);
    }

    public static List<int[]> moveCloud(int d, int s, List<int[]> clouds) {
        List<int[]> nextClouds = new ArrayList<>();
        for(int [] cloud : clouds) {
            int x = cloud[0];
            int y = cloud[1];
            int nx = ((x + dx[d] * s) % n + n) % n;
            int ny = ((y + dy[d] * s) % n + n) % n;
            board[nx][ny]++;
            nextClouds.add(new int[]{nx, ny});
        }
        return nextClouds;
    }

    public static void checkWater(List<int[]> clouds) {
        for(int[] cloud : clouds) {
            int x = cloud[0];
            int y = cloud[1];
            // 대각선 방향: 1, 3, 5, 7

            int cnt = 0;
            for(int i = 1; i <= 7; i += 2) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (board[nx][ny] == 0) continue;
                cnt++;
            }

            board[x][y] += cnt;
        }
    }

    public static void makeCloud(List<int[]> clouds, List<int[]> nextClouds) {
        clouds.clear();

        boolean[][] visited = new boolean[n][n];
        for(int[] cloud : nextClouds) visited[cloud[0]][cloud[1]] = true;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] >= 2) {
                    clouds.add(new int[]{i, j});
                    board[i][j] -= 2;
                }
            }
        }
    }

    public static void cal() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res += board[i][j];
            }
        }
    }
}
