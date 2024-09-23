import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int [][] board;
    static boolean[][] visited;
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(res);
    }

    private static void dfs(int count, int sum) {
        if (count == 3) {
            res = Math.min(res, sum);
            return;
        }

        for(int i = 1; i < n - 1; i++) {
            for(int j = 1; j < n - 1; j++) {
                if (!visited[i][j] && check(i,j)) {

                    int cur = add(i, j);
                    dfs(count + 1, sum + cur);
                    clear(i, j);
                }
            }
        }
    }

    private static boolean check(int i, int j) {
        for(int dir = 0; dir < 4; dir++) {
            int nx = i + dx[dir];
            int ny = j + dy[dir];
            if (visited[nx][ny]) return false;
        }
        return true;
    }

    private static int add(int i, int j) {
        visited[i][j] = true;
        int tmp = board[i][j];
        for(int dir = 0; dir < 4; dir++) {
            int nx = i + dx[dir];
            int ny = j + dy[dir];
            visited[nx][ny] = true;
            tmp += board[nx][ny];
        }
        return tmp;
    }

    private static void clear(int i, int j) {
        visited[i][j] = false;
        for(int dir = 0; dir < 4; dir++) {
            int nx = i + dx[dir];
            int ny = j + dy[dir];
            visited[nx][ny] = false;
        }
    }
}
