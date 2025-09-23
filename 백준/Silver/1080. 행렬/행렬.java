import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int[][] dest;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        dest = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                dest[i][j] = input.charAt(j) - '0';
            }
        }

        int cnt = 0;
        for(int i = 0; i <= n - 3; i++) {
            for(int j = 0; j <= m - 3; j++) {
                if (board[i][j] != dest[i][j]) {
                    reverse(i, j, board[i][j], dest[i][j]);
                    cnt++;
                }
            }
        }

        if (!checkResult(n, m)) System.out.println(-1);
        else System.out.println(cnt);
    }

    public static void reverse(int x, int y, int val, int newVal) {
        for(int i = x; i < x + 3; i++) {
            for(int j = y; j < y + 3; j++) {
                if (board[i][j] == newVal) board[i][j] = val;
                else board[i][j] = newVal;
            }
        }
//        print(board);
    }

    public static boolean checkResult(int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != dest[i][j]) return false;
            }
        }
        return true;
    }

//    public static void print(int[][] board) {
//        for(int i = 0; i < board.length; i++) {
//            for(int j = 0; j < board[i].length; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
}
