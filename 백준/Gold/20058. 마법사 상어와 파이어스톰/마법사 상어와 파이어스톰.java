import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, q;
    static int[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        int m = (int)Math.pow(2, n);
        board = new int[m][m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int k = 0; k < q; k++) {
            int l = Integer.parseInt(st.nextToken());

            int r = (int) Math.pow(2, l); // 해당 2^r 격자로 나눔
            board = divide(m,r);
            melt(m);
            // print(m);
        }
        System.out.println(sum(m));
        System.out.println(biggestArea(m));
    }

    public static int biggestArea(int m) {
        boolean[][] visited = new boolean[m][m];
        Queue<int[]> q = new LinkedList<>();

        int maxArea = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {

                int area = 1;
                if (!visited[i][j] && board[i][j] > 0) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;

                    while(!q.isEmpty()) {
                        int[] cur = q.poll();
                        int x = cur[0];
                        int y = cur[1];

                        for(int dir = 0; dir < 4; dir++) {
                            int nx = x + dx[dir];
                            int ny = y + dy[dir];
                            if (nx < 0 || ny < 0 || nx >= m || ny >= m) continue;
                            if (visited[nx][ny] || board[nx][ny] == 0) continue;

                            area++;
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }


    public static int sum(int m) {
        int sum = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                sum += board[i][j];
            }
        }
        return sum;
    }

    public static void melt(int m) {

        boolean[][] tmp = new boolean[m][m];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                int cnt = 0;
                for(int dir = 0; dir < 4; dir++) {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];
                    if (nx < 0 || ny < 0 || nx >= m || ny >= m) continue;
                    if (board[nx][ny] > 0) cnt++;
                }

                if (cnt < 3) tmp[i][j] = true;
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                if (tmp[i][j] && board[i][j] > 0) board[i][j] -= 1;
            }
        }
    }

    public static int[][] divide(int m, int r) {
        int[][] tmp = new int[m][m];
        for(int i = 0; i < m; i += r) {
            for(int j = 0; j < m; j += r) {
                rotate(i, j, r, tmp);
            }
        }
        return tmp;
    }

    public static int[][] rotate(int x, int y, int r, int[][] tmp) {
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < r; j++) {
                tmp[y + j][x + r - 1 -i] = board[y + i][x + j];
            }
        }
        return tmp;
    }

    public static void print(int m) {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
