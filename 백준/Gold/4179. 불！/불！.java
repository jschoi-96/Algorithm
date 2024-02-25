import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int r, c;
    static char[][] board = new char[1002][1002];
    static int[][] fire = new int[1002][1002];
    static int[][] ji = new int[1002][1002];
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static Queue<int[]> queue = new LinkedList<>();
    static Queue<int[]> ji_Queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = input.charAt(j);
                fire[i][j] = -1;
                ji[i][j] = -1;
                if (board[i][j] == 'F') {
                    fire[i][j] = 0;
                    queue.add(new int[] { i, j });
                }

                if (board[i][j] == 'J') {
                    ji[i][j] = 0;
                    ji_Queue.add(new int[] { i, j });
                }

            }
        }

        // 불에 대한 BFS
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c)
                    continue;
                if (fire[nx][ny] >= 0 || board[nx][ny] == '#')
                    continue;
                fire[nx][ny] = fire[x][y] + 1;
                queue.add(new int[] { nx, ny });
            }
        }

        while (!ji_Queue.isEmpty()) {
            int[] cur = ji_Queue.poll();
            int x = cur[0];
            int y = cur[1];
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) { // 범위를 벗어났다면, 탈출에 성공했다는 뜻
                    System.out.println(ji[x][y] + 1);
                    return;
                }
                if (ji[nx][ny] >= 0 || board[nx][ny] == '#')
                    continue; // 방문했거나, 벽인 경우
                if (fire[nx][ny] != -1 && fire[nx][ny] <= ji[x][y] + 1) //
                    continue;
                ji[nx][ny] = ji[x][y] + 1;
                ji_Queue.add(new int[] { nx, ny });

            }
        }
        System.out.println("IMPOSSIBLE");

    }
}
