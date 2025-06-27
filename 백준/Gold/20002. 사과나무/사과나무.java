import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n+1][n+1];
        int[][] prefix = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = board[i][j] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
            }
        }


        int max = -1000;
        for(int k = 1; k <= n; k++) { // 1부터 k까지 나눠서 계산
            for(int i = 1; i <= n - k + 1; i++) {
                for(int j = 1; j <= n - k + 1; j++) {
                    int res = prefix[i+k-1][j+k-1] - prefix[i-1][j+k-1] - prefix[i+k-1][j-1] + prefix[i-1][j-1];
                    max = Math.max(max, res);
                }
            }
        }
        System.out.println(max);
    }
}
