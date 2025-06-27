import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] board;
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[n][m];
        if (n * m < 3) {
            System.out.println(0);
            return;
        }

        dfs(0, 0, 0, visited);
        System.out.println(res);
    }

    public static void dfs(int x, int y, int cur, boolean[][] visited) {

        if (x == n) {
            res = Math.max(res, cur);
            return;
        }

        int nx = x;
        int ny = y + 1;
        if (ny == m) { // 오른쪽으로 진행하다 끝에 도달하면 한칸 내려가서 다시 진행
            nx++;
            ny = 0;
        }

        if (y - 1 >= 0 && x + 1 < n && !visited[x][y] && !visited[x][y-1] && !visited[x+1][y]) {
            visited[x][y] = true; visited[x][y-1] = true; visited[x+1][y] = true;
            int cost = 2 * board[x][y] + board[x][y-1] + board[x+1][y];
            dfs(nx, ny, cur + cost, visited);
            visited[x][y] = false; visited[x][y-1] = false; visited[x+1][y] = false;
        }

        if (y - 1 >= 0 && x - 1 >= 0 && !visited[x][y] && !visited[x][y-1] && !visited[x-1][y]) {
            visited[x][y] = true; visited[x][y-1] = true; visited[x-1][y] = true;
            int cost = 2 * board[x][y] + board[x][y-1] + board[x-1][y];
            dfs(nx, ny, cur + cost, visited);
            visited[x][y] = false; visited[x][y-1] = false; visited[x-1][y] = false;
        }

        if (x - 1 >= 0 && y + 1 < m && !visited[x][y] && !visited[x-1][y] && !visited[x][y+1]) {
            visited[x][y] = true; visited[x-1][y] = true; visited[x][y+1] = true;
            int cost = 2 * board[x][y] + board[x - 1][y] + board[x][y + 1];
            dfs(nx, ny, cur + cost, visited);
            visited[x][y] = false; visited[x-1][y] = false; visited[x][y+1] = false;
        }

        if (y + 1 < m && x + 1 < n && !visited[x][y] && !visited[x][y+1] && !visited[x+1][y]) {
            visited[x][y] = true; visited[x][y+1] = true; visited[x+1][y] = true;
            int cost = 2 * board[x][y] + board[x][y + 1] + board[x + 1][y];
            dfs(nx, ny, cur + cost, visited);
            visited[x][y] = false; visited[x][y+1] = false; visited[x+1][y] = false;
        }

        dfs(nx, ny, cur, visited); // 놓지 못하는 경우
    }
}
