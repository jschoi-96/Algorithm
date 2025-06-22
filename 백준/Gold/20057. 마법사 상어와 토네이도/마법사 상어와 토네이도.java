import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] board;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int[][] left = {{0, -2}, {-1, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {1, 1}, {-2, 0}, {2, 0}};
    static int[][] down = {{2, 0}, {1, -1}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {0, -2}, {0, 2}};
    static int[][] right = {{0, 2}, {-1, 1}, {1, 1}, {-1, 0}, {1, 0}, {-1, -1}, {1, -1}, {-2, 0}, {2, 0}};
    static int[][] up = {{-2, 0}, {-1, -1}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 1}, {0, -2}, {0, 2}};
    static int[] ratio = {5, 10, 10, 7, 7, 1, 1, 2, 2};
    static int[][][] sandDirs = {left, down, right, up};
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = n/2, y = n/2;
        int len = 1;
        int dir = 0;

        while (true) {
            for(int d = 0; d < 2; d++) { // 방향 2개씩 끊어서 이동
                for(int i = 0; i < len; i++) { // len만큼 이동
                    x += dx[dir];
                    y += dy[dir];

                    moveSand(x, y, dir);
                    if (x == 0 && y == 0) {
                        System.out.println(res);
                        return;
                    }
                }
                dir = (dir + 1) % 4;
            }
            len++; // 두 방향을 다 돌고 값 증가
        }
    }

    public static void moveSand(int x, int y, int dir) {
        int[][] sandDir = sandDirs[dir];
        int total = board[x][y];
        int spreadSum = 0;
        for(int i = 0; i < 9; i++) {
            int nx = x + sandDir[i][0];
            int ny = y + sandDir[i][1];

            int spread = total * ratio[i] / 100;
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) { // 격자 밖으로 나가는 경우
                res += spread; // 전체 값에 더해줌
            }

            else board[nx][ny] += spread; // 아닌 경우에 기존 모래 값에 더해줌
            spreadSum += spread;
        }

        // 알파 모래 계산
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if (nx < 0 || ny < 0 || nx >= n || ny >= n) res += (total - spreadSum);
        else board[nx][ny] += (total - spreadSum);
        board[x][y] = 0; // 기존 모래 값 초기화
    }
}
