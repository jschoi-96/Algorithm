import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, l;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (isPossible(board[i])) cnt++;
        }

        for(int j = 0; j < n; j++) {
            int[] col = new int[n];
            for(int i = 0; i < n; i++) {
                col[i] =  board[i][j];
            }
            if (isPossible(col)) cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean isPossible(int[] row) {
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n - 1; i++) {
            int cur = row[i];
            int next = row[i+1];
            if (cur == next) continue;
            if (Math.abs(next - cur) >= 2) return false; // 높이가 2이상 차이나는 경우

            if (next - cur == 1) { // 높아지는 형태의 계단
                for(int j = i; j > i - l; j--) {
                    if (j < 0 || row[j] != cur || visited[j]) return false;
                    visited[j] = true;
                }
            }

            else if (cur - next == 1) { // 낮아지는 형태의 계단
                for(int j = i + 1; j < i + 1 + l; j++) {
                    if (j >= n || row[j] != next || visited[j]) return false;
                    visited[j] = true;
                }
            }
        }
        return true;
    }
}
