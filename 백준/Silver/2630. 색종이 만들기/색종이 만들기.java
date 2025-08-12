import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void dfs(int x, int y, int n) {
        boolean flag = true;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (board[x][y] != board[i + x][j + y]) {
                    flag = false;
                    break;
                }

                if (!flag) break;
            }
        }

        if (flag) {
            if (board[x][y] == 0) white++;
            else blue++;
        }

        else {
            dfs(x, y, n / 2);
            dfs(x + n / 2, y, n / 2);
            dfs(x, y + n / 2, n / 2);
            dfs(x + n / 2, y + n / 2, n / 2);
        }
    }
}
