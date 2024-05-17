import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 1. 백트래킹과 BFS를 활용하는 문제같음
 2. 길이가 3이 될때까지 벽을 모두 배치하고, 백트래킹을 돌면서 계속 넓이를 구함
 3. 최댓값을 계속 갱신해줌
 */
public class Main {
    static int n, m;
    static int [][] board;
    static boolean [][] visited;
    static int [] dx = {1, 0, -1, 0};
    static int [] dy = {0, 1, 0, -1};
    static int max_area = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(max_area);
    }

    public static void dfs(int depth) {
        if (depth == 3) {
            // 안전거리 계산하는 메서드
            bfs();
            return;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;
                    dfs(depth + 1);
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        int [][] tmp = new int [n][m];

        for(int i = 0; i < n; i++) {
            tmp[i] = board[i].clone();
        }

        visited = new boolean[n][m]; // 매번 초기화
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                if (tmp[i][j] == 2) {
                    queue.add(new int[]{i, j}); // 바이러스 큐에 집어넣음
                    visited[i][j] = true;
                    while(!queue.isEmpty()) {
                        int [] cur = queue.poll();
                        int x = cur[0];
                        int y = cur[1];

                        for(int dir = 0; dir < 4; dir++) {
                            int nx = x + dx[dir];
                            int ny = y + dy[dir];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if (!visited[nx][ny] && tmp[nx][ny] == 0) {
                                queue.add(new int[]{nx, ny});
                                tmp[nx][ny] = 2;
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }

        calculate(tmp);
    }

    public static void calculate(int [][] tmp) {
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (tmp[i][j] == 0) {
                    count++;
                }
            }
        }
        max_area = Math.max(max_area, count);
    }
}