import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char [][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 0;
    static int r,c,k;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        visited = new boolean[r][c];

        for(int i = 0; i < r; i++){
            String input = br.readLine();
            for(int j = 0; j < c; j++){
                board[i][j] = input.charAt(j);
            }
        }

        int[] start = new int[]{r - 1, 0};
        dfs(start, 1);
        System.out.println(cnt);
    }

    public static void dfs(int[] pos, int dist) {
        int x = pos[0];
        int y = pos[1];
        visited[x][y] = true;

        if (x == 0 && y == c - 1) {
            if (dist == k) cnt++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
            if (visited[nx][ny] || board[nx][ny] == 'T') continue;
            visited[nx][ny] = true;
            int[] next = new int[]{nx, ny};
            dfs(next, dist + 1);
            visited[nx][ny] = false;
        }
    }
}
