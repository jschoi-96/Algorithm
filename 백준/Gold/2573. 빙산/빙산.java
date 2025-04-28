import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
        1. 동서남북의 0의 갯수만큼 현재 값이 줄어든다. (단 0미만으로 x)
        2. 두 덩어리 이상으로 분리되는 최초의 년을 구하시오.

        1. while(true) 하면서 매 시간마다 방산 녹는 함수를 계산
        2. 그 뒤에 두 덩이로 나뉜지 체크하는 함수
        3. 두 덩어리 이상이라면 초를 리턴

        n, m = 300
        board[i][j] = 10000
        90000 * 10
     */
    static int [][] board;
    static int [][] nearby;
    static boolean[][] visited;
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
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

        int time = 0;
        while(true) {

            nearby = new int[n][m];
            visited = new boolean[n][m];

            int divided = 0;
            // 배열을 순회하며 0 초과인 빙산이 있는 경우 bfs를 돌린다.
            for(int i = 1; i < n - 1; i++) {
                for(int j = 1; j < m - 1; j++) {
                    if (!visited[i][j] && board[i][j] > 0) {
                        divided++;
                        bfs(i, j);
                    }
                }
            }

            if (divided > 1) {
                System.out.println(time);
                return;
            }

            if (finished() && divided == 0) {
                System.out.println(0);
                return;
            }
            melt();
//            for (int i = 0; i < n; i++) {
//                for(int j = 0; j < m; j++) {
//                    System.out.print(board[i][j] + " ");
//                }
//                System.out.println();
//            }

            time++;
        }
    }

    public static void bfs(int a, int b) {
        visited[a][b] = true;

        Queue<int []> q = new LinkedList<>();
        q.add(new int [] {a,b});

        while(!q.isEmpty()) {
            int [] cur = q.poll();
            int x = cur[0],y = cur[1];

            int zero_cnt = 0;
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if (board[nx][ny] == 0) zero_cnt++;

                if (board[nx][ny] == 0) continue; // 방문된 곳, 0인 지점은 큐에 넣지 않는다.
                q.add(new int[] {nx,ny});
                visited[nx][ny] = true;
            }

            //System.out.println(zero_cnt);
            nearby[x][y] = zero_cnt;
            // System.out.println(board[x][y] + " " + zero_cnt);
        }
    }

    public static void melt() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] -= nearby[i][j];
                if (board[i][j] < 0) board[i][j] = 0;
            }
        }
    }

    public static boolean finished() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != 0) return false;
            }
        }
        return true;
    }
}
