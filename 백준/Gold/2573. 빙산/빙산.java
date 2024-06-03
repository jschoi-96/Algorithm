import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
        1. 4분면에 있는 0의 개수만큼 값이 줄어듬
        2. 두 덩어리로 분리되는 최초의 시간을 구함
     */
    static int n, m;
    static int [][] board;
    static int [][] tmp;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int year = 0;
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
        int min = 0;
        while (year <= 1) {
            bfs();
            min++;
            if (allMelt()) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(min - 1);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[n][m];
        tmp = new int[n][m];
        year = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (!visited[i][j] && board[i][j] != 0) { // 빙산이고, 방문하지 않은 지역
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    year++;

                    if (year > 1) break;

                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int x = cur[0];
                        int y = cur[1];
                        int zero_count = 0;
                        for(int dir = 0; dir < 4; dir++){
                            int nx = x + dx[dir];
                            int ny = y + dy[dir];
                            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                            if (visited[nx][ny]) continue;
                            if (board[nx][ny] == 0) zero_count++;

                            if (board[nx][ny] != 0) {
                                queue.add(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }

                        }
                        tmp[x][y] = zero_count;
                    }
                }
            }
        }
        cal(tmp);
    }

    public static void cal(int [][] tmp) {
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] -= tmp[i][j];
                if (board[i][j] < 0) board[i][j] = 0;
            }
        }
    }

    public static boolean allMelt() {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++){
                if (board[i][j] != 0) return false;
            }
        return true;
    }
}