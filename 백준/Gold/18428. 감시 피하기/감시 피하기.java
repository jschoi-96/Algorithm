import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static char[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<int[]> list = new ArrayList<>();
    static boolean[] visited = new boolean[30];
    static boolean hide = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = st.nextToken().charAt(0);
                if (board[i][j] == 'X') list.add(new int[]{i, j});
            }
        }

        dfs(0, 0);
        if (hide) System.out.println("YES");
        else System.out.println("NO");
    }

    public static void dfs(int depth, int start) {

        if (hide) return;

        if (depth == 3) {
            // print(board);
            if (isPossible()) hide = true;
            return;
        }

        for(int i = start; i < list.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                int[] cur = list.get(i);
                board[cur[0]][cur[1]] = 'O'; // 장애물 설치
                dfs(depth + 1, i + 1);
                visited[i] = false;
                board[cur[0]][cur[1]] = 'X'; // 장애물 제거
            }
        }
    }

    public static boolean isPossible() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (board[i][j] == 'T') {
                    if (checkStudent(i, j)) return false;
                }
            }
        }
        return true; // 학생들이 모두 감시에서 피하는 경우
    }

    public static boolean checkStudent(int i, int j) {
        for(int dir = 0; dir < 4; dir++) {
            int x = i;
            int y = j;
            while (true) {
                x += dx[dir];
                y += dy[dir];
                if (x < 0 || y < 0 || x >= n || y >= n) break;
                if (board[x][y] == 'O') break;
                if (board[x][y] == 'S') return true;
            }
        }
        return false;
    }

    public static void print(char[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}