import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static char[][] board;
    static int[][] fire;
    static int[][] jihun;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        fire = new int[r][c];
        jihun = new int[r][c];

        Queue<int[]> f = new LinkedList<>();
        boolean[][] fire_visited = new boolean[r][c];

        Queue<int[]> q = new LinkedList<>();
        boolean[][] jihun_visited = new boolean[r][c];

        boolean hasFire = false;
        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = input.charAt(j);
                if (board[i][j] == 'F') {
                    f.add(new int[]{i, j});
                    fire_visited[i][j] = true;
                    hasFire = true;
                }

                else if (board[i][j] == 'J') {
                    q.add(new int[]{i, j});
                    jihun_visited[i][j] = true;
                }
            }
        }

        // 불을 먼저 이동시킨다.
        while (!f.isEmpty()) {
            int[] cur = f.poll();
            int x = cur[0];
            int y = cur[1];
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if (fire_visited[nx][ny] || board[nx][ny] == '#') continue;
                fire[nx][ny] = fire[x][y] + 1;
                fire_visited[nx][ny] = true;
                f.add(new int[]{nx, ny});
            }
        }

        boolean flag = false;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if (x == 0 || y == 0 || x == r - 1 || y == c - 1) {
                System.out.println(jihun[x][y] + 1);
                flag = true;
                break;
            }
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if (jihun_visited[nx][ny] || board[nx][ny] == '#' || board[nx][ny] == 'F') continue;

                if (!hasFire) {
                    jihun[nx][ny] = jihun[x][y] + 1;
                    jihun_visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }

                if (fire[nx][ny] <= jihun[x][y] + 1) continue;
                jihun[nx][ny] = jihun[x][y] + 1;
                jihun_visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }

//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//                System.out.print(jihun[i][j] + " ");
//            }
//            System.out.println();
//        }

        if (!flag) System.out.println("IMPOSSIBLE");
    }
}