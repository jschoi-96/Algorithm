import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];

        int val = 1;
        int limit = 1;
        int x = n / 2, y = n / 2;
        while (true) {
            for(int i = 0; i < limit; i++) {
                board[y--][x] = val++;
            }

            if (val > n * n) break;

            for (int i = 0; i < limit; i++) {
                board[y][x++] = val++;
            }

            limit++;
            for(int i = 0; i < limit; i++) {
                board[y++][x] = val++;
            }

            for (int i = 0; i < limit; i++) {
                board[y][x--] = val++;
            }
            limit++;
        }

        int nx = 0, ny = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == target) {
                    nx = i + 1;
                    ny = j + 1;
                }
            }
        }

        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(nx + " " + ny);
    }
}
