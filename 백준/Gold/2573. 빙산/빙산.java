import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static int[][] zero_count;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static int m;
    // BFS를 돌리면서 근처에서 0의 갯수를 세고, 갯수만큼 빼준다.
    // BFS의 시작점이 2개일 때, 최초의 시간을 구한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while(true) {
            if (!existsIce()) {
                System.out.println(0);
                return;
            }

            if (isSeperated()) {
                System.out.println(year);
                return;
            }

            year++;
        }
    }

    public static boolean existsIce() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] > 0) {
                    return true; // 아직 빙산이 남아있음
                }
            }
        }
        return false;
    }

    public static boolean isSeperated() {
        visited = new boolean[n][m]; // visited 배열 초기화
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (board[i][j] != 0 && !visited[i][j]){
                    if (count > 0) { // 빙산이 처음 분리되는 조건
                        return true;
                    }
                    bfs(i,j);
                    count++;
                }
            }
        }
        melt();
        return false;
    }

    public static void melt() {
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] = Math.max(0, board[i][j] - zero_count[i][j]);
            }
        }
    }

    public static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        zero_count = new int[n][m];
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            // 주위에 0의 갯수를 세줌
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (board[nx][ny] == 0) {
                    zero_count[x][y]++;
                }
            }

            // BFS 로직
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (board[nx][ny] == 0 || visited[nx][ny]) continue;
                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
}