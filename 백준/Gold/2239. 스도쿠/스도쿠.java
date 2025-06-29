import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean solved = false;
    static int[][] board = new int[9][9];
    /*
        열에 1 ~ 9가 중복되면 안된다
        행에 1 ~ 9가 중복되면 안된다
        3 x 3으로 나눴을 때 1 ~ 9까지 모두 중복없이 입력되야 한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++) {
            String input = br.readLine();
            for(int j = 0; j < 9; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }


        dfs(0, 0);
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void dfs(int row, int col) {

        if (solved) return;

        if (col == 9) { // 오른쪽 끝에 도달한 경우 밑으로
            // System.out.println(row + " " + col);
            dfs(row + 1, 0);
            return;
        }

        if (row == 9) {
            solved = true;
            return;
        }

        if (board[row][col] != 0) { // 이미 번호가 할당된경우, 스킵
            dfs(row, col + 1);
        }

        else {
            for(int i = 1; i <= 9; i++) {
                if (isValid(row, col, i)) { // 놓을 수 있는 숫작 있는 경우
                    board[row][col] = i;
                    dfs(row, col + 1);

                    if (!solved) board[row][col] = 0;
                }
            }
        }
    }

    public static boolean isValid(int row, int col, int val) {
        for(int i = 0; i < 9; i++) { // 세로 체크
            if (board[row][i] == val) return false;
        }

        for(int i = 0; i < 9; i++) {
            if (board[i][col] == val) return false;
        }

        int r = (row / 3) * 3;
        int c = (col / 3) * 3;
        for(int i = r; i < r + 3; i++) {
            for(int j = c; j < c + 3; j++) {
                if (board[i][j] == val) return false;
            }
        }
        return true;
    }
}
