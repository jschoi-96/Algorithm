import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m, d;
    static int [][] board;
    static boolean [] visited;
    static int [] tmp = new int[3];
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(max);
    }

    public static void dfs(int start, int depth) {
        if (depth == 3) {
//            for(int i = 0; i < 3; i++) {
//                System.out.print(tmp[i] + " ");
//            }
            bfs();
            return;
        }

        for(int i = start; i < m; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp[depth] = i;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void bfs() {
        int [][] temp = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                temp[i][j] = board[i][j];
            }
        }

        int kills = 0;

        for(int i = 0; i < n; i++) {
            List<int[]> targets = new ArrayList<>();

            for(int j = 0; j < 3; j++) {
                int col = tmp[j]; // 해당 궁수의 열 위치
                int [] target = findTarget(temp, col);
                if (target != null) {
                    targets.add(target);
                }
            }

            // 중복된 적 제거하지 않도록 제거 시 0으로 변경
            for(int [] target : targets) {
                int x = target[0];
                int y = target[1];
                if (temp[x][y] == 1) {
                    temp[x][y] = 0;
                    kills++;
                }
            }

            move(temp);
            max = Math.max(max, kills);
        }
    }

    public static int [] findTarget(int[][] temp, int col) {
        int [] target = null;
        int minDist = d + 1;
        for(int i = n - 1; i >= 0; i--) { // 아래서부터 위로 탐색을 이어감
            for(int j = 0; j < m; j++) {
                if (temp[i][j] == 1) {
                    int dist = Math.abs(n - i) + Math.abs(col - j); // 궁수의 좌표는 항상 n으로 시작
                    if (dist <= d) {
                        if (dist < minDist || (dist == minDist && j < target[1])) {
                            minDist = dist;
                            target = new int[]{i, j};
                        }
                    }
                }
            }
        }
        return target;
    }

    public static void move(int [][] temp) {
//        for(int i = 0; i < temp.length; i++) {
//            for(int j = 0; j < temp[i].length; j++) {
//                System.out.print(temp[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        for(int i = n - 1; i > 0; i--) {
            for(int j = 0; j < m; j++) {
                temp[i][j] = temp[i-1][j];
            }
        }

        for(int j = 0; j < m; j++) {
            temp[0][j] = 0;
        }
    }
}
