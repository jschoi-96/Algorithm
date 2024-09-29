import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String input = br.readLine();

            if (input.equals("end")) {
                System.out.println(sb);
                break;
            }

            // x가 선공을 하므로 3x3일 때, x의 갯수가 o보다 반드시 하나 더 많아야 한다.
            // XXX
            // OO.
            // XXX

            // .XX
            // X.X
            // OOO


            // x -> 2,
            char [][] board = new char[3][3];

            int xCount = 0, oCount = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == 'X') xCount++;
                if (input.charAt(i) == 'O') oCount++;
            }



            int idx = 0;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++) {
                    board[i][j] = input.charAt(idx++);
                }
            }

            boolean xWin = win(board, 'X');
            boolean oWin = win(board, 'O');

            if (xWin && oWin) {
                sb.append("invalid\n");
            } else if (xWin && xCount == oCount + 1) {
                sb.append("valid\n");
            } else if (oWin && xCount == oCount) {
                sb.append("valid\n");
            } else if (!xWin && !oWin && xCount == oCount + 1 && xCount + oCount == 9) {
                sb.append("valid\n");
            } else {
                sb.append("invalid\n");
            }
        }
    }

    public static boolean win(char[][] board, char p) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == p && board[i][1] == p && board[i][2] == p) return true; // 가로 체크
            if (board[0][i] == p && board[1][i] == p && board[2][i] == p) return true; // 세로 체크
        }

        if (board[0][0] == p && board[1][1] == p && board[2][2] == p) return true;
        if (board[0][2] == p && board[1][1] == p && board[2][0] == p) return true;
        return false;
    }

}
