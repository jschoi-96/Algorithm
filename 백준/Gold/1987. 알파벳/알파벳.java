import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static char[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[] visited = new boolean[26];
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        visited[board[0][0] - 'A'] = true;
        backtrack(0, 0, 1);
        System.out.println(res);
    }

    public static void backtrack(int x, int y, int depth) {
        res = Math.max(res, depth);
        for(int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
            int next = board[nx][ny] - 'A';
            if (visited[next]) continue;

            visited[next] = true;
            backtrack(nx, ny, depth + 1);
            visited[next] = false;
        }
    }
}
