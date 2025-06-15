import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, x, y, k;
    static int[][] board;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0}; // 동 서 북 남
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int [] dice = new int[7];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) {
            int d = Integer.parseInt(st.nextToken()) - 1;

            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

            dice = move(d, dice);

            if (board[nx][ny] == 0) { // 이동 칸이 0이면, 바닥면에 있는 숫자가 칸에 복사된다.
                board[nx][ny] = dice[6];
            }

            else { // 아닌 경우엔, 칸에 있는 숫자가 주사위 바닥면으로 복사되며 칸은 0이됨.
                dice[6] = board[nx][ny];
                board[nx][ny] = 0;
            }

            System.out.println(dice[1]);
            x = nx;
            y = ny;
        }
    }

    public static int[] move(int d, int[] dice) {
        int[] newDice = new int[7];
        if (d == 0) {
            newDice[1] = dice[4];
            newDice[2] = dice[2];
            newDice[3] = dice[1];
            newDice[4] = dice[6];
            newDice[5] = dice[5];
            newDice[6] = dice[3];
        }

        else if (d == 1) { // 서쪽
            newDice[1] = dice[3];
            newDice[2] = dice[2];
            newDice[3] = dice[6];
            newDice[4] = dice[1];
            newDice[5] = dice[5];
            newDice[6] = dice[4];
        }

        else if (d == 2) { // 북쪽
            newDice[1] = dice[5];
            newDice[2] = dice[1];
            newDice[3] = dice[3];
            newDice[4] = dice[4];
            newDice[5] = dice[6];
            newDice[6] = dice[2];
        }

        else { // 남
            newDice[1] = dice[2];
            newDice[2] = dice[6];
            newDice[3] = dice[3];
            newDice[4] = dice[4];
            newDice[5] = dice[1];
            newDice[6] = dice[5];
        }
        return newDice;
    }
}
