import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int k = 0; k < t; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int turn = (d /45 % 8 + 8) % 8;
            int[][] board = new int[n][n];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < turn; i++) {
                turnClock(board, n);
            }

            print(board, n);
        }
    }
    public static void turnClock(int[][] board, int n) {
        int[][] tmp = new int[n][n];
        int m = n / 2;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                tmp[i][j] = board[i][j];
            }
        }
        // 1. (1,1), (2,2) .. -> (n+1)/2
        for(int i = 0; i < n; i++) {
            tmp[i][m] = board[i][i];
        }

        // 2. 가운데 열 -> (n,1) (n-1,2).. (1,n)
        for(int i = 0; i < n; i++) {
            tmp[i][n-1-i] = board[i][m];
        }

        // 3.
        for(int i = 0; i < n; i++) {
            tmp[m][i] = board[n-1-i][i];
        }

        for(int i = 0; i < n; i++) {
            tmp[i][i] = board[m][i];
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = tmp[i][j];
            }
        }
    }

    public static void print(int[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
