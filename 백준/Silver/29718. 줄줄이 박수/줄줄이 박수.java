import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, a;
    static int [][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        a = Integer.parseInt(br.readLine());

        int [] tmp = new int[m];
        for(int i = 0; i < m; i++) {
            int window = 0;
            for(int j = 0; j < n; j++) {
                window += board[j][i];
            }
            tmp[i] = window;
        }

        int window = 0;
        int max = 0;
        for(int i = 0; i < m; i++) {
            window += tmp[i];
            if (i >= a - 1) { // 2
                max = Math.max(max, window);
                window -= tmp[i - (a - 1)];
            }
        }
        System.out.println(max);
    }
}
