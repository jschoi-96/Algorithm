import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};
    static int n;
    static int[][] board;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1, 0);
        System.out.println(cnt);
    }

    public static void dfs(int x, int y, int d) {
        if (x == n -1 && y == n - 1) {
            cnt++;
            return;
        }

        for(int dir = 0; dir < 3; dir++) {
            if (d == 0 && dir == 1) continue; // 가로 방향일 때 세로 이동불가
            if (d == 1 && dir == 0) continue;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

            if (dir == 2) {
                if (board[nx][ny] != 0 || board[nx-1][ny] != 0 || board[nx][ny - 1] != 0) continue;
            }

            else {
                if (board[nx][ny] != 0) continue;
            }

            dfs(nx, ny, dir);
        }
    }
}
